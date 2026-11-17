package painter;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Path;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;


import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class RandomBrush implements Brush{
    private Random random = new Random();
    public void apply(GraphicsGroup paintLayer,BrushOptions brushOptions, Point location){
        int shapeType = random.nextInt(5);
        switch (shapeType) {
            case 1:
                createCircle(paintLayer, brushOptions, location);
                break;
            case 2:
                createSquare(paintLayer, brushOptions, location);
                break;
            case 3:
                createStar(paintLayer, brushOptions, location);
                break;
            case 4:
                createTriangle(paintLayer, brushOptions, location);
                break;
            case 5:
                createCross(paintLayer, brushOptions, location);
                break;
        }
    }
    private void createCircle(GraphicsGroup paintLayer, BrushOptions brushOptions, Point location) {
        double radius = brushOptions.getRadius();
        Ellipse circle = new Ellipse(location.getX() - radius, location.getY() - radius, radius * 2, radius * 2);
        circle.setFillColor(brushOptions.getColor());
        paintLayer.add(circle);
    }

    private void createSquare(GraphicsGroup paintLayer, BrushOptions brushOptions, Point location) {
        double size = brushOptions.getRadius() * 2;
        Rectangle square = new Rectangle(location.getX() - size / 2, location.getY() - size / 2, size, size);
        square.setFillColor(brushOptions.getColor());
        paintLayer.add(square);
    }

    private void createStar(GraphicsGroup paintLayer, BrushOptions brushOptions, Point location) {
        Path star = new Path();
        double size = brushOptions.getRadius();
        double centerX = location.getX();
        double centerY = location.getY();
        
        List<Point> starPoints = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            double outerAngle = i * Math.PI * 2 / 5;
            double innerAngle = outerAngle + Math.PI / 5;

            starPoints.add(new Point(
                centerX + Math.cos(outerAngle) * size,
                centerY + Math.sin(outerAngle) * size
            ));

            starPoints.add(new Point(
                centerX + Math.cos(innerAngle) * (size * 0.5),
                centerY + Math.sin(innerAngle) * (size * 0.5)
            ));
        }

        star.setVertices(starPoints); 
        star.setFillColor(brushOptions.getColor());
        paintLayer.add(star);
    }

    private void createTriangle(GraphicsGroup paintLayer, BrushOptions brushOptions, Point location) {
        Path triangle = new Path();
        double size = brushOptions.getRadius();
        double centerX = location.getX();
        double centerY = location.getY();
        
        List<Point> trianglePoints = new ArrayList<>();
        trianglePoints.add(new Point(centerX, centerY - size)); 
        trianglePoints.add(new Point(centerX - size, centerY + size)); 
        trianglePoints.add(new Point(centerX + size, centerY + size)); 

        triangle.setVertices(trianglePoints); 
        triangle.setFillColor(brushOptions.getColor());
        paintLayer.add(triangle);
    }

    private void createCross(GraphicsGroup paintLayer, BrushOptions brushOptions, Point location) {
        double size = brushOptions.getRadius();
        double centerX = location.getX();
        double centerY = location.getY();

        Line vertical = new Line(centerX, centerY - size, centerX, centerY + size);
        Line horizontal = new Line(centerX - size, centerY, centerX + size, centerY);

        vertical.setStrokeColor(brushOptions.getColor());
        horizontal.setStrokeColor(brushOptions.getColor());

        paintLayer.add(vertical);
        paintLayer.add(horizontal);
    }

    public String getName() {
        return "RandomBrush";
    }
}
