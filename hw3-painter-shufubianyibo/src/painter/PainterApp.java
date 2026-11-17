package painter;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.ui.Button;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class PainterApp {
    private Brush currentBrush;
    private CanvasWindow canvas;
    private final PaintSettingsView paintSettingsView;
    private List<Brush> availableBrushes = new ArrayList<>();
    private GraphicsGroup paintLayer = new GraphicsGroup();

    public PainterApp() {
        canvas = new CanvasWindow("Painter", 900, 800);
        canvas.add(paintLayer);
        availableBrushes.add(new SprayPaint());
        availableBrushes.add(new CirclesBrush());
        availableBrushes.add(new Eraser());
        availableBrushes.add(new RandomBrush());
        availableBrushes.add(new ImageBrush("MagicalJuice.png")); //I don't know how to fix it
        paintSettingsView = new PaintSettingsView(Color.BLUE, 60);
        canvas.add(paintSettingsView, 10 - paintSettingsView.getBounds().getMinX(), 10);

        canvas.onMouseDown(event -> paint(event.getPosition()));
        canvas.onDrag(event -> paint(event.getPosition()));
        double y = 300;
        for (Brush brush : availableBrushes) {
            addBrushButton(brush, y);
            y += 40;
        }
    }

    private void addBrushButton(Brush brush, double y) {
        Button button = new Button(brush.getName());
        button.setPosition(10, y);
        canvas.add(button);
        button.onClick(() -> {
            currentBrush = brush;
          });
    }

    private void paint(Point location) {
        BrushOptions brushOptions = paintSettingsView.getBrushOptions();
          
        currentBrush.apply(paintLayer, brushOptions, location);
    }

    public static void main(String[] args) {
        new PainterApp();
    }
}
