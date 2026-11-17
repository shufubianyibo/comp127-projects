import java.util.List;
import java.util.ArrayList;
import edu.macalester.graphics.Image;

import edu.macalester.graphics.GraphicsGroup;

public class Hat implements Decoration{
    private String name;
    private Image decor;
    private List<String> list = new ArrayList<>();


    public Hat(double size) {
        decor = new Image("null");
        name = "Hat";
        list.add("images/decor/BellHat.PNG");
        list.add("images/decor/BowHat.PNG");
        list.add("images/decor/ChiefHat.PNG");
        list.add("images/decor/Mask.PNG");
        list.add("images/decor/RoundGlass.PNG");
        list.add("images/decor/SantaHat.PNG");
        list.add("images/decor/SquareGlass.PNG");
    }

    public String getName() {
        return name;
    }

    public String getType(int n) {
        String fileName = list.get(n);
        String typeName = "";
        for (int i = 13; i < fileName.length()-4; i++) {
            char c = fileName.charAt(i);
            typeName = typeName + c; 
        }      
        return typeName;
    }

    public List<String> getList() {
        return list;
    }

    public void changeDecor(int n) {
        Image image = new Image(list.get(n));
        decor = image;
    }

    public void addDecor(GraphicsGroup decorLayer, CharacterBody character) {
        decor.setCenter(character.getCenter().getX() + 100, character.getCenter().getY() + 100);
        decorLayer.add(decor);
    }

    

    public void removeDecor(GraphicsGroup decorLayer) {
            decorLayer.remove(decor);
    }
    

    @Override
    public Image getImage() {
        return decor;
    }

    @Override
    public void setImage(Image newImage) {
        this.decor = newImage;
    }

} 