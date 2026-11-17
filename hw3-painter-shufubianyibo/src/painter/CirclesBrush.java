package painter;


import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;

import edu.macalester.graphics.Point;

public class CirclesBrush implements Brush {
    public void apply(GraphicsGroup paintLayer,BrushOptions brushOptions, Point location) {
        double radius = brushOptions.getRadius();
        Ellipse circle = new Ellipse(location.getX() - radius, location.getY() - radius, radius * 2, radius * 2);
        circle.setStrokeColor(brushOptions.getColor());
        circle.setStrokeWidth(radius * 0.1); 
        circle.setFilled(false);
        circle.setCenter(location);
        paintLayer.add(circle);
    }

    public String getName() {
        return "Circles Brush";
    }
}
