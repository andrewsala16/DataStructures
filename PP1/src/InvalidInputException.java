/**
 * Exception class for invalid input
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 19, 2021
 * Last Date Modified: Februrary 28, 2021
 */
public class InvalidInputException extends Exception{
    public InvalidInputException(){
        super("Invalid input");
    }

    public InvalidInputException(String s){
        super(s);
    }

}
