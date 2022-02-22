import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that uses recursive methods to find word in a directory path
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 17, 2021
 * Last Date Modified: Februrary 18, 2021
 */
public class Recursion {
    public static void main(String[] args) {
        // test
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a path: ");
        String path = keyboard.next();
        System.out.println("Enter a word: ");
        String word = keyboard.next();
        findWord(path, word);

        System.out.println("Enter a path: ");
        path = keyboard.nextLine();
        long size = getSize(path);
        String unit = "bytes";
        if(size > 1000000000){
            size /= 1000000000;
            unit = "Gbytes";
        }
        else if(size > 1000000){
            size /= 1000000;
            unit = "Mbytes";
        }
        else if(size > 1000){
            size /= 1000;
            unit = "Kbytes";
        }
        System.out.println("Size of " + path + ": " + size + unit);

    }

    /**
     * Resursive method that prints the number of occurences of a word in  the files under the directory path
     * @param word for the word being searched in directory path
     * @param path for the path that is searched
     */
    public static void findWord(String path, String word) {
        File file = new File(path);
        if(file.isFile()){
            int count = countWord(file, word);
            if(count != 0){
                System.out.println(word + " appears " + count + " times in " + file.getAbsolutePath());
            }
        }
        else if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File value : files) {
                findWord(value.getAbsolutePath(), word);
            }
        }
        else{
            System.out.println("Directory not found");
        }
    }

    /**
     * Method to find number of times a word appears in a file
     * @param word for the word being searched in file
     * @param file for the file that is searched
     * @return number of times word appears in file
     */
    private static int countWord(File file, String word) {
        int count = 0;
        try{
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()){
                String line = readFile.nextLine();
                int index = line.indexOf(word, 0);
                while(index != 1){
                    count++;
                    index = line.indexOf(word, index+1);
                }
            }
            readFile.close();
        }
        catch(FileNotFoundException e){
        }
        return count;
    }

    /**
     * Recursive method that returns the total size of the directory in bytes
     * @param path for the directoru path being sized
     * @return the size of the directory in bytes
     */
    public static long getSize(String path) {
        long size = 0;
        File file = new File(path);
        if(file.isFile()){
            return file.length();
        }
        else if(file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                size += getSize(files[i].getAbsolutePath());
            }
        }
        return size;
    }
}
