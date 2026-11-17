package bicyclemodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BicycleTest {
    @Test
    void setDirection(){
        Bicycle bicycle = new Bicycle();
        bicycle.setDirection(15.0);
        assertEquals(15.0, bicycle.getDirection());
        bicycle.setDirection(104.0);
        assertEquals(90.0, bicycle.getDirection());
        bicycle.setDirection(-1004.0);
        assertEquals(-90.0, bicycle.getDirection());
    }
}
