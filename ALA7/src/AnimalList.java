
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class AnimalList {
    public static void main(String[] args) {
        ArrayList<String> animalAL = new ArrayList<>();
        LinkedList<String> animalLL = new LinkedList<>();
        readFile(animalAL, animalLL, "animals.txt");
        testContains(animalAL, animalLL, "animals.txt");
        testAdd(animalAL, animalLL);
        testRemove(animalAL, animalLL);
    }


    public static void readFile(ArrayList<String> al, LinkedList<String> ll, String filename) {
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                String name = read.nextLine();
                al.add(name);
                ll.add(name);
            }
            read.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }

    public static void testContains(ArrayList<String> al, LinkedList<String> ll, String filename){
        int totalIterAL = 0;
        int totalIterLL = 0;
        System.out.println("Testing the method contains");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations AL", "Iterations LL");
        for (int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random()*al.size());
            String randomName = al.get(randomIndex);
            int iterAL = al.contains(randomName);
            int iterLL = ll.contains(randomName);
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, iterAL, iterLL);
            totalIterAL += iterAL;
            totalIterLL += iterLL;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalIterAL/20, totalIterLL/20);
    }

    public static void testAdd(ArrayList<String> al, LinkedList<String> ll){
        int totalIterAL = 0;
        int totalIterLL = 0;
        System.out.println("\nTesting the method add");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations AL", "Iterations LL");
        for (int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random()*al.size());
            String randomName = al.get(randomIndex);
            int iterAL = al.add(randomIndex, randomName);
            int iterLL = ll.add(randomIndex, randomName);
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, iterAL, iterLL);
            totalIterAL += iterAL;
            totalIterLL += iterLL;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalIterAL/20, totalIterLL/20);
    }

    public static void testRemove(ArrayList<String> al, LinkedList<String> ll){
        int totalIterAL = 0;
        int totalIterLL = 0;
        System.out.println("\nTesting the method remove");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations AL", "Iterations LL");
        for (int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random()*al.size());
            String randomName = al.get(randomIndex);
            int iterAL = al.remove(randomName);
            int iterLL = ll.remove(randomName);
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, iterAL, iterLL);
            totalIterAL += iterAL;
            totalIterLL += iterLL;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalIterAL/20, totalIterLL/20);
    }
}
