/**
 * Class to model Media diagram
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 3, 2021
 * Last Date Modified: Februrary 4, 2021
 */
public class Show extends Media{
    // member
    int seasons;

    /**
     * Default constructor
     * Calls super from class Media
     * Initializes seasons to int 0
     */
    public Show() {
        super();
        seasons = 0;
    }

    /**
     * Constructor with four parameters
     * three inherited from class Media
     * @param seasons for the amount of seasons in a show
     */
    public Show(String title, String genre, String rating, int seasons) {
        super(title, genre, rating);
        this.seasons = seasons;
    }

    /**
     * Getter for the amount of seasons in a show
     * no parameters
     * @return the value of the data member seasons
     */
    public int getSeasons() {
        return seasons;
    }

    /**
     * Setter for the amount of seasons in a show
     * @param seasons to set the data member seasons
     * no return value
     */
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    /**
     * Method to get the Show information
     * no parameters
     * @return formatted string containing the value of the data members
     */
    @Override
    public String toString() {
        return String.format("%sSeasons: %d\n", super.toString(), seasons);
    }
}
