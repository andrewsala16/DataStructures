import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        BST<String> bst = new BST<>();
        HashMap<String, String> hashT = new HashMap<>(50000);
        ArrayList<String> words = new ArrayList<>();
        readData(hashT, words, "dictionary.txt");
        java.util.Collections.shuffle(words);
        for (String word : words) {
            bst.add(word);
            ll.add(word);
        }

        int llTotal = 0;
        int bstTotal = 0;
        int hashTotal = 0;
        System.out.printf("%-20s\t%-10s\t%-10s\t%-10s\n", "Word", "Linked List", "BST", "Hash Map");
        for (int i = 0; i < 1000; i++) {
            int index = (int)(Math.random() * words.size());
            String word = words.get(index);
            int llIter = ll.contains(word);
            int bstIter = bst.contains(word);
            hashT.get(word);
            int hashIter = HashMap.iterations;
            if (i % 50 == 0){
                System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", word, llIter, bstIter, hashIter);
            }
            llTotal += llIter;
            bstTotal += bstIter;
            hashTotal += hashIter;
        }
        System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", "Average", llTotal/1000, bstTotal/1000, hashTotal/1000);
        System.out.println("Maximum number of collisions: " + hashT.collisions());

    }

    private static void readData(HashMap<String, String> h, ArrayList<String> al, String filename) {
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] items = line.split("\\|");
                al.add(items[0]);
                h.put(items[0], items[1]);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

}
