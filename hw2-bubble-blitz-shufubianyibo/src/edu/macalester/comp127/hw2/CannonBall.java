package edu.macalester.comp127.hw2;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

/**
 * Represents a cannon ball that follows a parabolic arc based on physics equations.
 */
@SuppressWarnings("WeakerAccess")
public class CannonBall {
    public static final double GRAVITY = -9.8;
    public static final double BALL_RADIUS = 2.5;

    private double cCenterX;
    private double cCenterY;
    private double vX;
    private double vY;
    private double maxXBound;
    private double maxYBound;
    private Ellipse ballShape;

    public CannonBall(
            double centerX,
            double centerY,
            double initialSpeed,
            double initialAngle,
            double maxX,
            double maxY) {


        ballShape = new Ellipse(centerX,centerY,5,5);
        cCenterX = centerX;
        cCenterY = centerY;
        maxXBound = maxX;
        maxYBound = maxY;

        double initialAngleRadians = Math.toRadians(initialAngle);
        double initialvX = initialSpeed * Math.cos(initialAngleRadians);
        double initialvY = initialSpeed * -Math.sin(initialAngleRadians);
        vX = initialvX;
        vY = initialvY;
        

    }
    public double getCenterX(){
        return cCenterX;
    }
    public double getCenterY(){
        return cCenterY;
    }
    /**
     * Update the cannon ball's position if it is in bounds
     * @return true if the ball is in within the maxXBound and maxYBound
     */
    public boolean updatePosition(double dt) {

        cCenterX += dt * vX;
        cCenterY += vY * dt;
        vY = vY - GRAVITY * dt;
        ballShape.setCenter(cCenterX, cCenterY);
        if (cCenterX <= maxXBound && cCenterY <= maxYBound && cCenterX >= 0 && cCenterY >= 0){
            return true;
        } else {
            return false;
            
        }
        
    }

    /**
     * Adds the cannonball's shape to the given canvas.
     */
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ballShape);
    }

    /**
     * Removes the cannonball's shape from the given canvas.
     */
    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ballShape);
    }
}
