import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
/**
 * Class to test the classes
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 3, 2021
 * Last Date Modified: Februrary 4, 2021
 */
public class Test {
    public static void main(String[] args) {
        Media[] mediaList = new Media[50];
        File file = new File("media.txt");
        int count = 0;
        Scanner in = new Scanner(System.in);
        try{
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()){
                String line = readFile.nextLine();
                String[] each = line.split("\\|");
                String type = each[0];
                String title = each[1];
                String genre = each[2];
                String rating = each[3];
                int val = Integer.parseInt(each[4]);
                Media uno;

                if(type.equals("Movie")){
                    uno = new Movie(title, genre, rating, val);
                }
                else if(type.equals("Show")){
                    uno = new Show(title, genre, rating, val);
                }
                else{
                    uno = null;
                }
                mediaList[count] = uno;
                count++;
            }
            readFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Cannot find file");

        }

        boolean running = true;
        while (running){
            System.out.println("Select an operation:\n" +
                    "1: View Media List\n" +
                    "2: Search Media By Title\n" +
                    "3: Add a New Media\n" +
                    "4: Remove an Existing Media\n" +
                    "5: Sort Media\n" +
                    "6: Exit\n");

            Scanner scnr = new Scanner(System.in);
            int choice = scnr.nextInt();
            switch (choice) {
                case 1:
                    printMedia(mediaList, mediaList.length);
                    break;
                case 2:
                    System.out.println("Enter title of media:");
                    Scanner scann = new Scanner(System.in);
                    findMedia(mediaList, mediaList.length, scann.next());
                    break;
                case 3:
                    printMedia(mediaList, 2);
                    break;
                case 4:
                    System.out.println("Enter a genre (Drama, Comedy, Sci-Fi, Animation, Documentary)");
                    String genreChoice = scnr.next();
                    break;
                case 5:
                    printMedia(mediaList, 0);
                    break;
                case 6:
                    System.out.println("Bye");
                    running = false;
                default:
                    System.out.println("Invalid operation. Try Again");
            }
        }
    }


    public static int findMedia(Media[] list, int count, String title){
        for (int i = 0; i < count; i++) {
            if (Objects.equals(list[i].getTitle(), title)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Method to sort first number of count objects in array based on genre
     * @param list for the array of Medias being sorted by genre
     */
    public static void sortMedia(Media[] list, int count){
        Media temp;
        for(int i=0;i<count;i++) {
            for (int j = i + 1; j < count; j++) {
                if (list[i].getGenre().compareToIgnoreCase(list[j].getGenre()) > 0) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }



    /**
     * Method to print the first given count number of elements in array list
     * @param list for the array of Medias being searched
     * @param count for the number of elements
     */
    public static void printMedia(Media[] list, int count){
        for (int i = 0; i < count; i++) {
            System.out.println(list[i]);
        }
    }

    public static boolean checkRating(String rating, String type) throws InvalidRatingException {
        if(type.equalsIgnoreCase("movie")){
            if (rating.matches("G|PG|PG-13|R|NC-17")){
                return true;
            }
            else {
                throw new InvalidRatingException("Invalid rating: " + rating + ". Must be G, PG, PG-13, R, or NC-17");
            }
        }

        else{
            if (rating.matches(" TV-Y|TV-Y7|TV-G|TV-PG|TV-14|TV-MA")){
                return true;
            }
            else {
                throw new InvalidRatingException("Invalid rating: " + rating + ". Must be TV-Y, TV-Y7, TV-G, TV-PG, TV-14, TV-MA");
            }

        }
    }
}

