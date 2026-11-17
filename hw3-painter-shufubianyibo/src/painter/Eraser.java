package painter;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

public class Eraser implements Brush{
    public void apply (GraphicsGroup paintLayer, BrushOptions brushOptions, Point location) {
        GraphicsObject err = paintLayer.getElementAt(location);
        if (err != null) {
            paintLayer.remove(err);
        }
    }  
    
    public String getName() {
        return "Eraser";
    }
}
