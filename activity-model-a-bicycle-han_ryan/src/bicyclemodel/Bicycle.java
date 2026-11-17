package bicyclemodel;

public class Bicycle {
    private Double direction;
    private static final double drag = 0.1;
    private static final double pedalPower = 2;
    private static final double brakingPower = 3;

    public double getDirection(){
        Double d = 0.0;
        if (direction <= 90.0 && direction >= - 90.0){
            d = direction;
        }
        else if (direction > 90.0){
            d = 90.0;
        }
        else {
            d = -90.0;
        }
        return d;
    }
    public void setDirection(double direction){
        this.direction = direction;
    }
    private Double speed;
    public double getSpeed(){
        return speed;
    }
    public void pedalHarder(){
        Double speedAfterH;
        speedAfterH = (speed + pedalPower) * (1 - drag);
        speed = speedAfterH;
    }
    public void brake(){
        Double speedAfterB;
        speedAfterB = (speed - brakingPower) * (1-drag);
        if (speedAfterB < 0){
            speedAfterB = 0.0;
        }
        speed = speedAfterB;
        
    }
}
