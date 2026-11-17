package restaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantExplorer {
    public static void main(String [] args) {
        // Step 1. Create a new empty HashMap.
        // The keys should be the names of the restaurant.
        // The values should be the restaurant objects.
        Map<String, Restaurant> restaurantByName = new HashMap<>();

        // Step 2. Add five restaurants to the map (hint: use put()).
        restaurantByName.put("Cafe Mac", new Restaurant("Cafe Mac", "International", 1));
        restaurantByName.put("My Burger", new Restaurant("My Burger", "American", 4));
        restaurantByName.put("Hot Hands", new Restaurant("Hot Hands", "American", 5));
        restaurantByName.put("Cheng Heng Restaurant", new Restaurant("Cheng Heng Restaurant", "Cambodian", 5));
        restaurantByName.put("McD", new Restaurant("McD", "American", 2));

        // Step 3. Print the names of each restaurant (hint: use keySet()).
        System.out.println(restaurantByName.keySet());

        // Step 4. Remove one of the restaurants by name. Check to make sure
        // it no longer exists and print out the result (hint: use containsKey()).
        restaurantByName.containsKey("McD");
        restaurantByName.remove("McD");
        restaurantByName.containsKey("McD");
        System.out.println(restaurantByName.keySet());

        // Step 5. Print the restaurant objects (hint: use values())
        System.out.println(restaurantByName.values());

        // Step 6. Print the restaurant names and objects (hint: use entrySet()).
        System.out.println(restaurantByName.entrySet());
    }
}
