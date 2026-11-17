package comp127.weather.widgets;

import comp127.weather.api.CurrentConditions;
import comp127.weather.api.ForecastConditions;
import comp127.weather.api.WeatherData;
import edu.macalester.graphics.*;

import java.util.ArrayList;
import java.util.List;

public class ForecastWidget implements WeatherWidget {

    private final double size;
    private GraphicsGroup group;

    // TODO: Add instance variables for any UI elements that you create in the constructor but
    //       will need to update later with new data
    private GraphicsText date;
    private GraphicsText time;
    private GraphicsText temp;
    private GraphicsText range;
    private GraphicsText description;
    private Image icon;

    private GraphicsGroup boxGroup;  // Holds all the ForecastBox objects

    private List<ForecastBox> boxes = new ArrayList<>();

    public ForecastWidget(double size) {
        this.size = size;

        group = new GraphicsGroup();

        // TODO: Create the fixed text and image elements you will need (but not the row of boxes
        //       at the bottom; those you will create in the `update` method)

        icon = new Image(0, 0);
        icon.setMaxWidth(size);
        icon.setMaxHeight(size * 0.3);
        group.add(icon);

        date = new GraphicsText();
        date.setFont(FontStyle.BOLD, size * 0.07);
        group.add(date);
        time = new GraphicsText();
        time.setFont(FontStyle.BOLD, size * 0.07);
        group.add(time);
        temp = new GraphicsText();
        temp.setFont(FontStyle.BOLD, size * 0.07);
        group.add(temp);
        range = new GraphicsText();
        range.setFont(FontStyle.BOLD, size * 0.07);
        group.add(range);
        description = new GraphicsText();
        description.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(description);

        boxGroup = new GraphicsGroup();
        group.add(boxGroup);

        updateLayout();
    }

    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    public void update(WeatherData data) {
        // TODO: We are getting new data, so we need to stop showing the old data.
        //       Remove all the existing elements from `boxGroup`.
        //
        //       HINT: check the javadoc for `GraphicsGroup` to keep this simple!
        boxGroup.removeAll();
        boxes.clear();  // Remove all the old ForecastBoxes from our list

        // TODO: Loop through all the `ForecastConditions` objects from `data`, and for each one:
        //   - Wrap it in a new `ForecastBox`
        //   - Position it to the right of the previous box, wrapping to a new line if you are
        //     past the end of the current one.
        //   - Add the new box to the graphics group
        //   - Add the new box to the `boxes` list
        List<ForecastConditions> forecastConditions = data.getForecasts();
        double boxX = size * 0.05;
        double boxY = size * 0.85;
        for (ForecastConditions forecast : forecastConditions) {
            ForecastBox box = new ForecastBox(forecast, boxX, boxY, size*0.03, size*0.05);
            boxGroup.add(box);
            boxes.add(box);
            boxX += size*0.035;
            if (boxX > size - size * 0.035) {  
                boxX = size * 0.05;            
                boxY += size * 0.07;           
            }
        }

        // TODO: Call `selectForecast` with the first `ForecastBox`, which will update the various
        //       text and icon elements.
        selectForecast(boxes.get(0));
        // If all this is daunting, or you get stuck, or it gets too complicated, then look at the
        // file `doc/forecast-update-pseudocode.java`. It has another version of the hints for this
        // method spelled out just a bit more.
    }

    private void selectForecast(ForecastBox box) {
        // TODO: Call `setActive` for all the forecast boxes, with `true` for the selected box and
        //       `false` for all the others (so that the previously active box becomes inactive).
        for (ForecastBox b : boxes) {
            b.setActive(b == box);  
        }
        // TODO: Get the forecast data from the box, and use it to update the text and icon.
        ForecastConditions forecast = box.getForecast();
        date.setText(FormattingHelpers.HANDLE_NA_DATE(forecast.getPredictionTime()));
        time.setText(FormattingHelpers.HANDLE_NA_TIME(forecast.getPredictionTime()));
        icon.setImagePath(forecast.getWeatherIcon());
        range.setText(FormattingHelpers.HANDLE_NA(forecast.getMinTemperature()) + "\u2109" + " | " 
        + FormattingHelpers.HANDLE_NA(forecast.getMaxTemperature()) + "\u2109");
        temp.setText(
            FormattingHelpers.HANDLE_NA(forecast.getTemperature())  
            + "\u2109");  

        description.setText(forecast.getWeatherDescription());
        updateLayout();
    }

    private void updateLayout() {
        date.setCenter(size * 0.23, size * 0.05);
        time.setCenter(size * 0.8, size * 0.05);
        icon.setCenter(size * 0.5, size * 0.35);
        temp.setCenter(size * 0.5, size * 0.65);
        range.setCenter(size * 0.5, size * 0.725);
        description.setCenter(size * 0.5, size * 0.8);
    }

    /**
     * Given a position in the widget, this returns the ForecastBox at that position if one exists
     *
     * @param location pos to check
     * @return null if not over a forecast box
     */
    private ForecastBox getBoxAt(Point location) {
        GraphicsObject obj = group.getElementAt(location);
        if (obj instanceof ForecastBox) {
            return (ForecastBox) obj;
        }
        return null;
    }

    /**
     * Updates the currently displayed forecast information as the mouse moves over the widget.
     * If there is not a ForecastBox at that position, the display does not change.
     */
    @Override
    public void onHover(Point position) {

        ForecastBox hoveredBox = getBoxAt(position);
        if (hoveredBox != null) {
            selectForecast(hoveredBox);  
        }
    }
}
