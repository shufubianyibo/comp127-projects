package painter;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;

public class SprayPaint implements Brush{
    public void apply(GraphicsGroup paintLayer, BrushOptions brushOptions, Point location) {
        GraphicsObject dot = PaintUtils.createFuzzyDot(brushOptions.getColor(), brushOptions.getRadius(), 0.2f);
        dot.setCenter(location); 
        paintLayer.add(dot);
    }

    public String getName() {
        return "Spray Paint";
    }
}
