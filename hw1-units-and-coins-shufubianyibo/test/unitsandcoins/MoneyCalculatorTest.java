package unitsandcoins;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class MoneyCalculatorTest {
    @Test
    public void testSimpleAmount() {
        assertEquals(
            List.of("1 penny"),
            MoneyCalculator.convertToCash(1)
        );
    }

    @Test
    public void testSingulars() {
        assertEquals(
            List.of(
                "1 hundred",
                "1 twenty",
                "1 ten",
                "1 five"
            ),
            MoneyCalculator.convertToCash(13500)
        );
        assertEquals(
            List.of(
                "1 ten",
                "1 five",
                "1 one",
                "1 quarter",
                "1 dime",
                "1 nickel",
                "1 penny"
            ),
            MoneyCalculator.convertToCash(1641)
        );
    }

    @Test
    public void testPlurals() {
        assertEquals(
            List.of(
                "3 hundreds",
                // no plural is possible for fifties, because 2 fifties = 1 hundred
                "2 twenties",
                // no plural possible for tens
                // no plural possible for fives
                "4 ones",
                "2 quarters",
                "2 dimes",
                // no plural possible for nickels
                "3 pennies"
            ),
            MoneyCalculator.convertToCash(34473)
        );
    }

    @Test
    public void test11() {
        assertEquals(
            List.of(
                "1 ten",
                "1 one"
            ),
            MoneyCalculator.convertToCash(1100)
        );    
    }
    @Test
    public void test029() {
        assertEquals(
            List.of(
                "1 quarter",
                "4 pennies"
            ),
            MoneyCalculator.convertToCash(29)
        );    
    }
}
