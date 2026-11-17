
import edu.macalester.graphics.GraphicsGroup;

import edu.macalester.graphics.Image;


/* Handles the character body sprite and updating the image when color values are changed. */

public class CharacterBody extends GraphicsGroup {
    private String imagePath;
    private Image bodyImage;
    // private Image outlineOverlay;  
    // private Image highlightOverlay;  

    private float[] originalPixels;

    private final double LIGHTEN_VALUE = 1;
    private final double COLOR_STRENGTH = 1;
    private final float DARK_THRESHOLD = 0.2f;  
    private final float LIGHT_THRESHOLD = 0.8f;  



    
    public CharacterBody(String imagePath) {
        this.imagePath = imagePath;

        this.bodyImage = new Image(imagePath);
        // this.outlineOverlay = new Image("res/images/character/characterBodyOutline.png");
        // this.highlightOverlay = new Image("res/images/character/characterBodyHighlight.png");
        this.originalPixels = bodyImage.toFloatArray(Image.PixelFormat.ARGB); // Save original pixels

        add(bodyImage);
        // add(outlineOverlay);   
        // add(highlightOverlay); 
    }

    /* Takes scaled rgb values and creates a colorized image that replaces existing characterbody image */
    public void updateBodyColor(float redScale, float greenScale, float blueScale) {
        remove(bodyImage); // remove current image
        System.out.println("removing old body image " + bodyImage);

        float[] newPixels = new float[originalPixels.length];


        // for each pixel in the order argb, recolors and adjusts for brightness
        for (int i = 0; i < newPixels.length; i += 4) { 
            newPixels[i] = originalPixels[i]; 


            float red = originalPixels[i + 1];
            float green = originalPixels[i + 2];
            float blue = originalPixels[i + 3];

            
            // calc relative/percieved brightness from formula (found on stack overflow)
            float brightness = 0.299f * red + 0.587f * green + 0.114f * blue;


            float scaleFactor = 1.0f;
            if (brightness < DARK_THRESHOLD) {
                scaleFactor = .5f; // Reduce effect for dark pixels
            } else if (brightness > LIGHT_THRESHOLD) {
                scaleFactor = 1.5f; // Reduce effect for light pixels
            }
    
            newPixels[i + 1] = (float) red * redScale * (redScale + scaleFactor);
            newPixels[i + 2] = (float) green * greenScale * (greenScale + scaleFactor);
            newPixels[i + 3] = (float) blue * blueScale * (blueScale + scaleFactor);
        }

        bodyImage = new Image(bodyImage.getImageWidth(), bodyImage.getImageHeight(), newPixels, Image.PixelFormat.ARGB);
        
        add(bodyImage);
        System.out.println("adding new body image " + bodyImage);

    }

    public String getImagePath() {
        return imagePath;
    }

    public Image getImage() {
        return bodyImage;
    }


}
