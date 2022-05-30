import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListIterator;
import java.util.Scanner;
/**
 * Test class to implement classes
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: April 5, 2022
 * Last Date Modified: April 17, 2022
 **/
public class Test {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>();
        LinkedList<String> lList = new LinkedList<>();
        DoublyLinkedList<String> dlList= new DoublyLinkedList<>();

        readFromFile(aList, "countries.txt");
        readFromFile(lList, "countries.txt");
        readFromFile(dlList, "countries.txt");

        System.out.println("Array List (Forward):");
        printListForward(aList);
        System.out.println();
        System.out.println("\nLinked List (Forward):");
        printListBackward(lList);
        System.out.println();
        System.out.println("\nDoubly Linked List (Forward):");
        printListBackward(dlList);
        System.out.println();

        System.out.println("\nArray List (Backward):");
        printListBackward(aList);
        System.out.println();
        System.out.println("\nLinked List (Backward):");
        printListForward(lList);
        System.out.println();
        System.out.println("\nDoubly Linked List (Backward):");
        printListForward(dlList);
    }

    public static void readFromFile(List<String> list, String filename) {
        File file = new File(filename);
        try {
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()) {
                String line = readFile.nextLine();
                list.add(line);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
    }

    public static <E> void printListForward(List<E> list) {
        ListIterator<E> iterator = list.listIterator();
        System.out.print("[");
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.print("]");
    }

    public static <E> void printListBackward(List<E> list) {
        ListIterator<E> iterator = list.listIterator(list.size());
        System.out.print("[");
        while(iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.print("]");
    }
}
