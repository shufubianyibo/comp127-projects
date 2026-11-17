package edu.macalester.comp127.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CannonBallTest {

    @Test
    public void testBasicUpdatePosition() {
        CannonBall ball = new CannonBall(100, 100, 100, 45, 1100, 600);
    
        ball.updatePosition(0.1);
        assertEquals(107.071, ball.getCenterX(), 0.001);
        assertEquals(92.9289, ball.getCenterY(), 0.001);
    
        ball.updatePosition(0.1);
        assertEquals(114.142, ball.getCenterX(), 0.001);
        assertEquals(85.9558, ball.getCenterY(), 0.001);
    
        ball.updatePosition(0.1);
        assertEquals(121.213, ball.getCenterX(), 0.001);
        assertEquals(79.0807, ball.getCenterY(), 0.001);
    }
    @Test
    public void testupdatePositionInbound() {
        CannonBall ball = new CannonBall(100, 100, 100, 45, 1100, 600);

        boolean inBounds = ball.updatePosition(0.1);
        assertTrue(inBounds);

    }
    @Test
    public void testBallOutOfBounds() {

        CannonBall ball = new CannonBall(100, 100, 100, 45, 1100, 600);

        for (int i = 0; i < 700; i++) {
            ball.updatePosition(0.1);
        }


        boolean inBounds = ball.updatePosition(0.1);
        assertFalse(inBounds);

        CannonBall ball2 = new CannonBall(100, 100, 100, -45, 1100, 600);

        for (int i = 0; i < 100; i++) {
            ball2.updatePosition(0.1);
        }


        boolean inBounds2 = ball2.updatePosition(0.1);
        assertFalse(inBounds2);
    }
}
