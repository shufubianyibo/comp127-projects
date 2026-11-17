package breakout;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Brick {
    private Rectangle brick;
    // build a brick
    public Brick(double x, double y, double width, double height, Color color) {
        brick = new Rectangle(x, y, width, height);
        brick.setFillColor(color);
    }
    // get the graphic of a brick
    public GraphicsObject getGraphics() {
        return brick;
    }  
}
