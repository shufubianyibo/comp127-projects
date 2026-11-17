package breakout;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;

public class Ball {
    private Ellipse ball;
    private double dx = 0, dy = -10;
    private int attempts = 3;
    // create ball
    public Ball(double x, double y, double radius) {
        Random random = new Random();
        ball = new Ellipse(x - radius, y - radius, radius * 2, radius * 2);
        dx = random.nextDouble() * 4 - 2;
        ball.setFillColor(Color.BLACK);
    }

    // modify the velocity of ball
    public void move() {
        ball.moveBy(dx, dy);
    }
    public void setVelocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    // modify the attempt
    public boolean checkAttempts(CanvasWindow canvas) {
        if (ball.getY() > canvas.getHeight()) {
            attempts--;
            if (attempts > 0) {
                ball.setCenter(canvas.getWidth()*0.5, canvas.getHeight()*0.5);
                bounceY();
            } 
            return true;           
        }else {
            return false;
        }
    }

    // get attempt
    public int getAttempts() {
        return attempts;
    }

    // check the collision between ball and other objects
    public void checkCollisions(CanvasWindow canvas, Paddle paddle, List<Brick> bricks) {
        // get the square that formed the ball
        double leftX = ball.getX();
        double rightX = ball.getX() + ball.getWidth();
        double topY = ball.getY();
        double bottomY = ball.getY() + ball.getHeight();
        
        GraphicsObject collisionObj = canvas.getElementAt(leftX, topY);
        if (collisionObj == null) collisionObj = canvas.getElementAt(rightX, topY);
        if (collisionObj == null) collisionObj = canvas.getElementAt(leftX, bottomY);
        if (collisionObj == null) collisionObj = canvas.getElementAt(rightX, bottomY);

        if (collisionObj != null && !(collisionObj instanceof GraphicsText)) {
            if (collisionObj == paddle.getGraphics()) {
                adjustVelocityOnPaddleHit(paddle); 
            } else {
                for (Brick brick : bricks) {
                    if (brick.getGraphics() == collisionObj) {
                        canvas.remove(collisionObj);
                        bricks.remove(brick);
                        bounceY(); 
                        break;
                    }
                }  
            }
        }
        
        if (ball.getX() <= 0 || ball.getX() >= canvas.getWidth() - ball.getWidth()) {
            bounceX();
        }

        if (ball.getY() <= 0) {
            bounceY();
        }
    }

    // change the velocity of the ball by the place it intersect with paddel
    private void adjustVelocityOnPaddleHit(Paddle paddle) {
        double paddleCenterX = paddle.getGraphics().getCenter().getX();
        double ballCenterX = ball.getCenter().getX();
        double distanceFromPaddleCenter = ballCenterX - paddleCenterX;
        double paddleHalfWidth = paddle.getGraphics().getWidth() / 2;
        double normalizedDistance = distanceFromPaddleCenter / paddleHalfWidth;
        double maxSpeed = 5;
        dx = normalizedDistance * maxSpeed;
        bounceY();
    }

    // reverse dy
    public void bounceY() {
        dy = -dy;
    }

    // reverse dx
    public void bounceX() {
        dx = -dx;
    }

    // get graphic of ball
    public GraphicsObject getGraphics() {
        return ball;
    }
}
