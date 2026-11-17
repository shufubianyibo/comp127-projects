package unitsandcoins;

/**
 * Unit Conversions for humorous units of measurement.
 *
 * @author Bret Jackson, Paul Cantrell, Libbey Shoop
 *
 * Acknowledgements:
 *   The Sheppy unit can be found on:
 *   https://en.wikipedia.org/wiki/List_of_humorous_units_of_measurement#Sheppey
 */
public class UnitConversions {
    /**
     * Converts the given distance in sheppeys to the corresponding distance in miles.
     */
    public static double sheppeysToMiles(double sheppeys) {
        double result = sheppeys * 7/8;

        return result;
    }
    public static double milesToSheppeys(double miles) {
        double result = miles * 8/7;

        return result;
    }

}

