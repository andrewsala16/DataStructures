import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ArrayList<Pair<String, String>> states;
        states = new ArrayList<>();
        readStates(states, "states.txt");
        ArrayList<Pair<String, Integer>> trees;
        trees = new ArrayList<>();
        readTrees(trees, "trees.txt");
        boolean running = true;
        while(running) {
            System.out.println("\nSelect an operation:\n" +
                    "1: View the list of states\n" +
                    "2: Search for a state\n" +
                    "3: Sort states by name\n" +
                    "4: Sort states by capital\n" +
                    "5: View the list of trees\n" +
                    "6: Search for a tree\n" +
                    "7: Sort trees by name\n" +
                    "8: Sort trees by height\n" +
                    "9: Exit\n");

            Scanner scnr = new Scanner(System.in);
            int choice = scnr.nextInt();
            switch (choice) {
                case 1: // print states
                    printArrayList(states);
                    break;
                case 2: // search for a state
                    System.out.println("Enter a state name:");
                    Scanner scanState = new Scanner(System.in);
                    String state = scanState.next();
                    int index = search(states, state);
                    if(index == -1){
                        System.out.println("State not found");
                    }
                    else{
                        System.out.println("State found: " + states.get(index));
                    }
                    break;
                case 3: // sort by name
                    states.sort(new ComparatorByFirst<>());
                    printArrayList(states);
                    break;
                case 4: // sort by capital
                    states.sort(new ComparatorBySecond<>());
                    printArrayList(states);
                    break;
                case 5: // view trees
                    printArrayList(trees);
                    break;
                case 6: // search for a tree
                    System.out.println("Enter a state name:");
                    Scanner scanTree = new Scanner(System.in);
                    String tree = scanTree.next();
                    index = search(trees, tree);
                    if(index == -1){
                        System.out.println("Tree not found");
                    }
                    else{
                        System.out.println("Tree found: " + trees.get(index));
                    }
                    break;
                case 7: // sort trees by name
                    trees.sort(new ComparatorByFirst<>());
                    printArrayList(trees);
                    break;
                case 8: // sort trees by height
                    trees.sort(new ComparatorBySecond<>());
                    printArrayList(trees);
                    break;
                case 9:
                    running = false;
                    break;

            }
        }
    }

    public static void readStates(
            ArrayList<Pair<String, String>> list,
            String filename){

        File file = new File(filename);
        try{
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine()){
                String line = scanFile.nextLine();
                String[] items = line.split("\\|");
                String name = items[0];
                String capital = items[1];
                Pair<String, String> p = new Pair<>(name, capital);
                list.add(p);
            }
            scanFile.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }

    }

    public static void readTrees(
            ArrayList<Pair<String, Integer>> list,
            String filename){

        File file = new File(filename);
        try{
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine()){
                String line = scanFile.nextLine();
                String[] items = line.split("\\|");
                String name = items[0];
                Integer height = Integer.parseInt(items[1]);
                Pair<String, Integer> p = new Pair<>(name, height);
                list.add(p);
            }
            scanFile.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }

    }

    public static <E1, E2> int search(ArrayList<Pair<E1, E2>> list, E1 key){
        for (int i = 0; i < list.size(); i++) {
            Pair<E1, E2> p = list.get(i);
            if(p.getFirst().equals(key)){
                return i;
            }
        }
        return -1;
    }

    public static <E> void printArrayList(ArrayList<E> list){
        for (E element: list) {
            System.out.println(element.toString());
        }
    }
}
