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
        Media[] mediaList = new Media[10];
        mediaList[0] = new Show("Archive81", "Sci-Fi", "TV-MA", 1);
        mediaList[1] = new Show("After Life", "Drama", "TV-MA", 3);
        mediaList[2] = new Movie("After We Fell", "Drama", "R", 98);
        mediaList[3] = new Show("The Witcher", "Drama", "TV-MA", 2);
        mediaList[4] = new Movie("Don't Look Up", "Drama", "R", 138);
        mediaList[5] = new Movie("The Alpinist", "Documentary", "PG-13", 92);
        mediaList[6] = new Movie("Miss Sloane", "Drama", "R", 131);
        mediaList[7] = new Show("Arcane - League of Legends", "Animation", "TV-14", 1);
        mediaList[8] = new Movie("The Girl with the Dragon Tattoo", "Drama", "R", 158);
        mediaList[9] = new Show("Arrested Development", "Comedy", "TV-MA", 5);

        boolean running = true;
        while (running){
            System.out.println("Select an operation:\n" +
                    "1: View Media List\n" +
                    "2: View Movies\n" +
                    "3: View Shows\n" +
                    "4: Search media by genre\n" +
                    "5: Sort media by rating\n" +
                    "6: Exit\n");

            Scanner scnr = new Scanner(System.in);
            int choice = scnr.nextInt();
            switch (choice) {
                case 1:
                    printMedia(mediaList, 0);
                    break;
                case 2:
                    printMedia(mediaList, 1);
                    break;
                case 3:
                    printMedia(mediaList, 2);
                    break;
                case 4:
                    System.out.println("Enter a genre (Drama, Comedy, Sci-Fi, Animation, Documentary)");
                    String genreChoice = scnr.next();
                    System.out.println(findGenre(mediaList, genreChoice) + " media found for the genre " + genreChoice);

                    break;
                case 5:
                    sortRating(mediaList);
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

    /**
     * Method to print the elements of given type in array list
     * @param list for the array of Medias being searched
     * @param type for the value to represent type of media
     *             0 - all media, 1 - movies, 2 - shows
     */
    public static void printMedia(Media[] list, int type){
        if (type == 0){
            for (Media media : list) {
                System.out.println(media.toString());
            }
        }
        else if (type == 1){
            for (Media media : list) {
                if(media.getClass().getName().equals("Movie")){
                    System.out.println(media);
                }
            }
        }
        else if (type == 2){
            for (Media media : list) {
                if (media.getClass().getName().equals("Show")){
                    System.out.println(media);
                }
            }
        }
    }

    /**
     * Method to search for elements in the array that are of given genre
     * @param list for the array of Medias being searched
     * @param genre for the genre that is being found in array
     * @return amount of media that are of given genre
     */
    public static int findGenre(Media[] list, String genre){
        int amount = 0;
        for (Media media: list) {
            if (media.getGenre().equals(genre)){
                System.out.println(media);
                amount++;
            }
        }
        return amount;
    }

    /**
     * Method to sort objects in array based on rating
     * @param list for the array of Medias being sorted by rating
     */
    public static void sortRating(Media[] list){
        Media temp;
        for(int i=0;i<list.length;i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i].getRating().compareToIgnoreCase(list[j].getRating()) > 0) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}
