import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Airplane {
    // member
    private char[][] seatMap;

    /**
     * Default constructor
     */
    public Airplane(){
        seatMap = new char[8][9];
        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++) {
                seatMap[i][j] = '.';
            }
        }
    }

    /**
     * Constructor with one parameter
     * @param filename for the name of file that seat map will be printed to
     */
    public Airplane(String filename){
        seatMap = new char[8][9];
        readMap(filename);
    }

    /**
     * Method that reads data from text file
     * @param filename for the name of file that seat map will be printed to
     */
    private void readMap(String filename){
        File file = new File(filename);
        try {
            Scanner readFile = new Scanner(file);
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    seatMap[i][j] = readFile.next().charAt(0);
                }
            }
            readFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    seatMap[i][j] = '.';
                }
            }
        }
    }

    /**
     * method to check if seat number exists
     * @param seatNumber for user input of seat number
     * @return true if seatNumber is valid
     * @throws InvalidSeatException if does not match the seat number array
     */
    private boolean checkSeatNumber(String seatNumber) throws InvalidSeatException {
        if (seatNumber.matches("[1-9][A-H]")){
            return true;
        }
        else {
            throw new InvalidSeatException("Invalid seat number: " + seatNumber + ". Must be [1-9][A-H]");
        }
    }

    /**
     * method to reserve seat on plane
     * @param seatNumber for user input of seat number
     * @return true if seatNumber is reserved
     * @throws InvalidSeatException if does not match the seat number array
     */
    public boolean reserveSeat(String seatNumber) throws InvalidSeatException {
        if(checkSeatNumber(seatNumber)){
            char rowNum = seatNumber.charAt(0);
            char colNum = seatNumber.charAt(1);
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';

            if(seatMap[row][col] == '.'){
                seatMap[row][col] = 'X';
                return true;
            }
        }
        else{
            return false;
        }
        return true;
    }

    /**
     * method to free seat that is taken
     * @param seatNumber for user input of seat number
     * @return true if seatNumber is freed
     * @throws InvalidSeatException if does not match the seat number array
     */
    public boolean freeSeat(String seatNumber) throws InvalidSeatException{
        if(checkSeatNumber(seatNumber)){
            char rowNum = seatNumber.charAt(0);
            char colNum = seatNumber.charAt(1);
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';

            if(seatMap[row][col] == 'X'){
                seatMap[row][col] = '.';
                return true;
            }
        }
        else{
            return false;
        }
        return true;
    }

    /**
     * method to write contents of array to file
     * @param filename for name of file being written to
     */
    public void saveMap(String filename){
        File file = new File(filename);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    writeFile.print(seatMap[i][j] + " ");
                }
                writeFile.println();
            }
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot write to file");
        }
    }

    /**
     * Method to make seat map a string
     * no parameters
     * @return formatted string of seat map
     */
    public String toString(){
        String output = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        for (int i = 0; i < seatMap.length; i++) {
            output += (i+1)+"\t";
            for (int j = 0; j < seatMap[i].length; j++) {
                output += seatMap[i][j] + "\t";
            }
            output += "\n";
        }
        return output;
    }
}
