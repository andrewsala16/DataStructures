public class InvalidInputException extends Exception{
    public InvalidInputException(){
        super("Invalid input bud");
    }

    public InvalidInputException(String s){
        super(s);
    }

}
