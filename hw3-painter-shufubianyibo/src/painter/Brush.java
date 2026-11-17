package painter;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

public interface Brush{
    public void apply(GraphicsGroup paintLayer,BrushOptions brushOptions, Point location);
    public String getName();
}
