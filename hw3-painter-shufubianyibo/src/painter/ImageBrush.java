package painter;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

import java.io.File;

public class ImageBrush implements Brush{
    private String imagePath;
    public ImageBrush(String imagePath) {
        this.imagePath = imagePath;
    }

    public void apply(GraphicsGroup paintLayer, BrushOptions brushOptions, Point location) {
        Image image = new Image(imagePath);
        image.setCenter(location);
        paintLayer.add(image);
    }

    public String getName() {
        File file = new File(imagePath);
        String fileName = file.getName();
        String brushName = "";
        for (int i = 0; i < fileName.length()-4; i++) {
            char c = fileName.charAt(i);
            brushName = brushName + c; 
        }
        
        return brushName;
    }
   
}
