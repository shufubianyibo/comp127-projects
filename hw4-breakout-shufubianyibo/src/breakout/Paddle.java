package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class Paddle {
    private Rectangle paddle;
    private double canvasWidth;
    private double paddleY;
    
    // create the paddle
    public Paddle (CanvasWindow canvas, double y, double width, double height) {
        this.canvasWidth = canvas.getWidth(); 
        this.paddleY = y; 
        paddle = new Rectangle(canvas.getWidth()/2, y, width, height);
        paddle.setFillColor(Color.BLACK);
        canvas.onMouseMove(event -> moveTo(event.getPosition().getX()));
    }
    // make the paddle able to move with mouse
    public void moveTo(double mouseX) {
        double clampedX = Math.max(paddle.getWidth() / 2, 
                                   Math.min(mouseX, canvasWidth - paddle.getWidth() / 2));
        paddle.setCenter(clampedX, paddle.getCenter().getY());
    }

    
    // get the graphic of paddle
    public GraphicsObject getGraphics() {
        return paddle;
    }
}
