package traincar;

import java.awt.Color;

import edu.macalester.graphics.Rectangle;


public class BoxCar extends TrainCar{
    /* Dimensions of the door panels on the boxcar */
    public static final double DOOR_WIDTH = 18 * SCALE;
    public static final double DOOR_HEIGHT = 32 * SCALE;
    public BoxCar(double x, double y, Color color) {
        super(color);
        double xRight = x + CONNECTOR + CAR_WIDTH / 2;
        double xLeft = xRight - DOOR_WIDTH;
        double yDoor = y - CAR_BASELINE - DOOR_HEIGHT;
        this.add(new Rectangle(xLeft, yDoor, DOOR_WIDTH, DOOR_HEIGHT));
        this.add(new Rectangle(xRight, yDoor, DOOR_WIDTH, DOOR_HEIGHT));
    }
}
