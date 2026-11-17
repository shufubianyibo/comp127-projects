package debugpractice;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Path;
import edu.macalester.graphics.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkluver on 11/17/17.
 */
public class Star extends GraphicsGroup {
    public void draw() {
        // get the star shape, centered at (0,0)
        List<Point> starPoints = getStarPoints();

        // make a copy so we can translate the points
        starPoints = new ArrayList<>(starPoints);

        // translate the shape to be correctly centered)

        Path poly = new Path(translateStarPoints(starPoints, new Point(100, 100)));
        poly.setFillColor(Color.YELLOW);
        add(poly);
    }

    // private void translateStarPoints(List<Point> points, Point delta) {
    //     for(int i = 0; i < points.size(); i++) {
    //         Point p = points.get(i);
    //         points.set(i, p.add(delta));
    //     }
    // }

    public List<Point> translateStarPoints(List<Point> starPoints, Point delta){
        return starPoints.stream()
            .map(s -> s.add(delta))
            .toList();
    }

    // Note: these points are all 100% correct.
    // There is no bug in this method.
    public List<Point> getStarPoints() {
        return List.of(
            new Point(58.78,   80.9),
            new Point(0.0,     40.0),
            new Point(-58.78,  80.9),
            new Point(-38.04,  12.36),
            new Point(-95.11, -30.9),
            new Point(-23.51, -32.36),
            new Point(0.0  ,  -100.0),
            new Point(23.51,  -32.36),
            new Point(95.11,  -30.9),
            new Point(38.04,   12.36));
    }

    public static void main(String[] args) {
        CanvasWindow window = new CanvasWindow("star", 200, 200);
        Star star = new Star();
        star.draw();
        window.add(star);
    }
}
