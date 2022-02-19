/**
 * Class to model Employee diagram; derived class
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 3, 2021
 * Last Date Modified: Februrary 3, 2021
 */
public class Employee extends Person {
    // members
    private int id;
    private String position;
    private double salary;

    /**
     * Default constructor
     * Calls super from class Person
     * Initializes id to int 0
     * Initializes position to string "none"
     * Initializes salary to double 0.0
     */
    public Employee() {
        super();
        id = 0;
        position = "none";
        salary = 0.0;
    }

    /**
     * Constructor with seven parameters
     * four inherited from class Person
     *
     * @param id     for the id of an employee
     * @param salary for the salary of an employee
     */
    public Employee(String name, String address, String phone, String email, int id, String position, double salary) {
        super(name, address, phone, email);
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    /**
     * Getter for id of an employee
     * no parameters
     *
     * @return the value of data member id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id of an employee
     *
     * @param id to set the data member id
     *           no return
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for position of an employee
     * no parameters
     *
     * @return the value of data member position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Setter for position of an employee
     *
     * @param position to set the data member position
     *                 no return
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Getter for salary of an employee
     * no parameters
     *
     * @return the value of data member salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Setter for salary of an employee
     *
     * @param salary to set the data member salary
     *               no return
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Method to get the Employee information
     * no parameters
     *
     * @return formatted string containing the value of the data members
     */
    @Override
    public String toString() {
        return String.format("%sID: %d\nPosition: %s\nSalary: %f\n", super.toString(), id, position, salary);
    }
}