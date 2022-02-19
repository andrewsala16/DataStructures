/**
 * Class to model Faculty diagram; dervied class
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 3, 2021
 * Last Date Modified: Februrary 3, 2021
 */
public class Faculty extends Employee {
    //member
    private String rank;

    /**
     * Default constructor
     * Calls super from class Employee
     * Initializes rank to string "none"
     */
    public Faculty(){
        super();
        rank = "none";
    }

    /**
     * Constructor with eight parameters
     * seven inherited from class Employee
     * @param rank for the rank of a faculty
     */
    public Faculty(String name, String address, String phone, String email, int id, String position, double salary, String rank){
        super(name, address, phone, email, id, position, salary);
        this.rank = rank;
    }

    /**
     * Getter for rank of faculty
     * no parameters
     * @return the value of data member rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Setter for rank of faculty
     * @param rank to set the data member rank
     * no return
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Method to get the Faculty information
     * no parameters
     * @return formatted string containing the value of the data members
     */
    public String toString(){
        return String.format("%sRank: %s\n", super.toString(), rank);
    }
}
