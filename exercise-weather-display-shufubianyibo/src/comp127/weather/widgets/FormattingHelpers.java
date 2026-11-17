package comp127.weather.widgets;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilities to help widgets convert numbers and dates to strings.
 */
@SuppressWarnings("WeakerAccess")
public class FormattingHelpers {
    /**
     * Converts a number to a string with one digit past the decimal point, e.g. "312.3".
     */
    public static final DecimalFormat ONE_DECIMAL_PLACE = new DecimalFormat("#0.0");

    /**
     * Converts a date to a string showing the date and day of week in abbreviated form,
     * e.g. "Mon, Oct 14".
     */
    public static final DateFormat WEEKDAY_AND_NAME = new SimpleDateFormat("E, MMM d");

    /**
     * Converts a date to a string showing the 12-hour time of day, e.g. "1:46 PM".
     */
    public static final DateFormat TIME_OF_DAY = new SimpleDateFormat("h:mm a");

    public static String HANDLE_NA(Double temp){
        if (temp == null){
            return "-";
        } else {
            return FormattingHelpers.ONE_DECIMAL_PLACE.format(temp);
        }
    }

    public static String HANDLE_NA_DATE(Date time){
        if (time == null){
            return "-";
        } else {
            return FormattingHelpers.WEEKDAY_AND_NAME.format(time);
        }
    }

    public static String HANDLE_NA_TIME(Date time){
        if (time == null){
            return "-";
        } else {
            return FormattingHelpers.TIME_OF_DAY.format(time);
        }
    }
}
