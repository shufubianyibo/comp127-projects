package breakout;

import java.util.ArrayList;
import java.util.List;


import java.awt.Color;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private CanvasWindow canvas;
    private Paddle paddle;
    private Ball ball;
    private List<Brick> bricks;
    private int attempts = 3;
    private GraphicsText attemptsText;
    private GraphicsText gameOverText;
    private GraphicsText victoryText;
    

    public BreakoutGame() {
        // initiallize the variables
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        paddle = new Paddle(canvas, canvas.getHeight()*0.7, 80, 15);
        ball = new Ball(canvas.getWidth() / 2, canvas.getHeight() / 2, 10);
        bricks = createBricks();
        attemptsText = new GraphicsText("Attempts: " + attempts);
        attemptsText.setFontSize(14);
        attemptsText.setPosition(10, 20);
        attemptsText.setFillColor(Color.BLACK);
        gameOverText = new GraphicsText("Game Over");
        gameOverText.setFontSize(36);
        gameOverText.setFillColor(Color.RED);
        gameOverText.setPosition(canvas.getWidth()/2, canvas.getHeight()/2);
        victoryText = new GraphicsText("Win!");
        victoryText.setFontSize(36);
        victoryText.setFillColor(Color.RED);
        victoryText.setPosition(canvas.getWidth()/2, canvas.getHeight()/2);
        
        // add the graphics
        canvas.add(attemptsText);
        canvas.add(paddle.getGraphics());
        canvas.add(ball.getGraphics());
        bricks.forEach(brick -> canvas.add(brick.getGraphics()));

        // call the methods
        canvas.animate(() -> {
            ball.move();
            ball.checkCollisions(canvas, paddle, bricks);
            // print attemps and win or lose
            if (ball.checkAttempts(canvas)) {
                if (ball.getAttempts() >= 0) {
                    attemptsText.setText("Attempts: " + ball.getAttempts());
                }
                if (ball.getAttempts() <= 0) {
                    canvas.add(gameOverText);
                    canvas.pause(1000);
                }
            }
            if (bricks.size() == 0) {
                canvas.add(victoryText);  
                canvas.pause(1000);
            }
        });
    }
    // create list of bricks
    public List<Brick> createBricks() {
        List<Brick> bricks = new ArrayList<>();
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
        for (int row = 0; row < colors.length; row++) {
            for (int col = 0; col < 10; col++) {
                Brick brick = new Brick(60 + col * 50, 50 + row * 20, 48, 15, colors[row]);
                bricks.add(brick);
            }
        }
        return bricks;
    }

    public static void main(String[] args){
        new BreakoutGame();
    }
}
