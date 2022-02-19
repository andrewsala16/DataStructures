/**
 * Class to model Student diagram; derived class
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 3, 2021
 * Last Date Modified: Februrary 3, 2021
 */

public class Student extends Person {
    // members
    private int id;
    private String major;

    /***
     * Default constructor
     * Calls super from class Person
     * Initializes id to int 0
     * Initializes major to empty string
     */
    public Student(){
        super();
        id = 0;
        major = "";
    }

    /***
     * Constructor with six parameters
     * four inherited from class Person
     * @param id for the id of a student
     * @param major for the major of a student
     */
    public Student(String name, String address, String phone, String email, int id, String major){
        super(name, address, phone, email);
        this.id = id;
        this.major = major;
    }

    /**
     * Getter for id of a Student
     * no parameters
     * @return the value of data member id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id of a Student
     * @param id to set the data member name
     * no return
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for major of a Student
     * no parameters
     * @return the value of data member major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Setter for major of a student
     * @param major to set the data member major
     * no parameters
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Method to get the Student information
     * no parameters
     * @return formatted string containing the value of the data members
     */
    @Override
    public String toString() {
        return String.format("%sID: %d\nMajor: %s\n", super.toString(), id, major);
    }
}
