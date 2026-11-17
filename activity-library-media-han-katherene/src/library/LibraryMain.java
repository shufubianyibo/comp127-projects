package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Interactive console simulation of a library.
 *
 * @author Abby Marsh Fall 2019
 */
public class LibraryMain {
    /**
     * Helper method to check an item out from the library
     * TODO: once you have implemented Media, change this to accept any Media type!
     *
     * @param title title of item to check out
     * @param library list of library items
     * @return true if item checked out successfully, false otherwise
     */
    public static boolean checkOut(String title, List<Media> library) {
        for(Media m : library) {
            if(m.getTitle().equalsIgnoreCase(title)) {
                return m.checkOut();
            }
        }
        return false;
    }

    /**
     * Helper method to check an item in to the library
     *
     * @param title title of item to check in
     * @param library list of library items
     * @return true if item checked in successfully, false otherwise
     */
    // TODO: once you have implemented Media, change this to accept any Media type!
    public static boolean checkIn(String title, List<Media> library) {
        for(Media m : library) {
            if(m.getTitle().equalsIgnoreCase(title)) {
                return m.checkIn();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // create/populate library
        // TODO: make this a list of Media objects, once your interface has been completed
        List<Media> library = new ArrayList<>();

        library.add(new Book("American Gods", "Neil Gaiman"));
        library.add(new Book("The Yiddish Policeman's Union", "Michael Chabon"));
        library.add(new Book("Pond", "Claire-Louise Bennett"));
        library.add(new Book("The Dream Songs", "John Berryman"));
        library.add(new Book("The Dud Avocado", "Elaine Dundy"));
        library.add(new Video("Video A", "A", 5, 5));
        library.add(new Video("Video B", "B", 4, 4));
        library.add(new Video("Video C", "C", 6, 6));
        library.add(new RareManuscripts("Manuscript A", "A"));

        // TODO: add Video objects to your library, once the class has been created
        // If you create additional Media classes, add those items too!


        // begin user prompts
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\nEnter a command to perform an action. Type \'help\' to see the list of commands");
            System.out.print("> ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("quit")) { // quit to exit
                break;
            }

            if(input.equalsIgnoreCase("help")) { // print list of commands
                showHelp();

            } else if (input.matches("checkout .+")) { // checking out an item
                if (checkOut(input.substring(9), library)) {
                    System.out.println("Checked out " + input.substring(9));
                } else {
                    System.out.println("Could not check out that title.");
                }

            } else if (input.matches("checkin .+")) { // checking in an item
                if(checkIn(input.substring(8), library)) {
                    System.out.println("Checked in " + input.substring(8));
                } else {
                    System.out.println("Could not check in that title.");
                }

            } else if (input.equalsIgnoreCase("list")) { // list all library items
                listm(library);

            } else { // invalid command
                System.out.println("Please enter a valid command");
            }
        }
        sc.close();
    }

    private static void listm(List<Media> library) {
        System.out.println("\n-----\nLibrary Inventory\n-----\n");

        // TODO: edit this to work for all Media items
        for(Media m : library) {
            System.out.println(m.toString());
        }
    }

    private static void showHelp() {
        System.out.println("The following commands are accepted:");
        System.out.println("\'list\': list all library items and whether they are available");
        System.out.println("\'checkout [title]\': checkout the item called [title]");
        System.out.println("\'checkin [title]\': checkin the item called [title]");
        System.out.println("\'quit\': exit the program");
    }
}
