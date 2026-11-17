package unitsandcoins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoneyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an amount of money: $");
        long amount = (long) (scanner.nextDouble() * 100);  // Grab first number on input line
        scanner.nextLine();  // Ignore remainder of line
        List<String> cashDenominations = convertToCash(amount);

        System.out.println("In currency, this is:");
        for (String denomination : cashDenominations) {
            System.out.println("  " + denomination);  // Each denomination on a separate line
        }

        scanner.close();
    }

    /**
     * Lists the minimal combination of US bills and coins that add up to a given dollar amount.
     * 
     * @param amount An amount in cent. Must be a multiple of 1.
     * @return A list of counts of cash denomations, e.g. "2 dimes", with one denomination
     *         per list element.
     */



    public static List<String> convertToCash(long amount) {
        long amountRemaining = amount;  // Tracks amount left after applying each denomination
        List<String> results = new ArrayList<>();  // Accumulates denominations
        List<Integer> denom_num = Arrays.asList(10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1);
        List<String> denom_s = Arrays.asList("hundred", "fifty", "twenty", "ten", "five", "one", "quarter", "dime", "nickel", "penny");
        List<String> denom_p = Arrays.asList("hundreds", "fifties", "twenties", "tens", "fives", "ones", "quarters", "dimes", "nickels", "pennies");
        for (int i = 0; i < denom_num.size(); i++){
            int x = (int) (amountRemaining / denom_num.get(i));  // How many hundreds in amountRemaining?
            if (x == 1) {  // Singular, plural, or none?
                results.add(x + " " + denom_s.get(i));
            } else if (x != 0) {
                results.add(x + " " + denom_p.get(i));
            }
            amountRemaining %= denom_num.get(i);  // Compute amount left after removing hundreds
        }


        return results;
    }
        
}


