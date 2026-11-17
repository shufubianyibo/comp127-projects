import java.util.List;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
public interface Decoration {
    
    public String getName();
    public void addDecor(GraphicsGroup decorLayer, CharacterBody character);
    public String getType(int n);
    public List<String> getList();
    public void changeDecor(int n);

    public Image getImage();
    public void setImage(Image image);
} 