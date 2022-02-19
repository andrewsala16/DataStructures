/**
 * Class to model Media diagram
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 3, 2021
 * Last Date Modified: Februrary 4, 2021
 */
public class Media {
    // members
    protected String title;
    protected String genre;
    protected String rating;

    /**
     * Default constructor
     * Initializes title, genre, and rating to an empty string
     */
    public Media(){
        title = "";
        genre = "";
        rating = "";
    }

    /**
     * Constructor with three parameters
     * @param title for the title of a media
     * @param genre for the genre of a media
     * @param rating for the rating of a media
     */
    public Media(String title, String genre, String rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }


    /**
     * Getter for the title of a media
     * no parameters
     * @return the value of the data member title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for the title of a media
     * @param title to set the data member title
     * no return value
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for the genre of a media
     * no parameters
     * @return the value of the data member genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Setter for the genre of a media
     * @param genre to set the data member genre
     * no return value
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Getter for the rating of a media
     * no parameters
     * @return the value of the data member rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * Setter for the raing of a media
     * @param rating to set the data member rating
     * no return value
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Method to get the Media information
     * no parameters
     * @return formatted string containing the value of the data members
     */
    @Override
    public String toString() {
        return String.format("Title: %s\nGenre: %s\nRating: %s\n", title, genre, rating);
    }

    /**
     * Method to write info to file
     * no parameters
     * @return formatted string containing the value of the data members separated by the delimeter
     */
    public String simpleString() {
        return getTitle() + " | " + getGenre() + " | " + getRating();
    }
}

