/**
 * Class to model Media diagram
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 3, 2021
 * Last Date Modified: Februrary 4, 2021
 */
public class Movie extends Media{
    // member
    // duration in minutes
    int duration;

    /**
     * Default constructor
     * Calls super from class Media
     * Initializes duration to int 0
     */
    public Movie() {
        super();
        duration = 0;
    }

    /**
     * Constructor with four parameters
     * three inherited from class Media
     * @param duration for the duration of a movie
     */
    public Movie(String title, String genre, String rating, int duration) {
        super(title, genre, rating);
        this.duration = duration;
    }

    /**
     * Getter for the duration of a movie
     * no parameters
     * @return the value of the data member duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Setter for the duration of a movie
     * @param duration to set the data member duration
     * no return value
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Method to get the Movie information
     * no parameters
     * @return formatted string containing the value of the data members
     */
    @Override
    public String toString() {
        return String.format("%sDuration: %d\n", super.toString(), duration);
    }

    /**
     * Method to write info to file
     * no parameters
     * @return formatted string containing the value of the data members separated by the delimeter
     */
    public String simpleString() {
        return getTitle() + " | " + getGenre() + " | " + getRating() + " |" + getDuration();
    }
}
