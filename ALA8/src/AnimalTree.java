import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnimalTree {
    public static void main(String[] args) {
        BST<String> animalBST = new BST<>();
        Heap<String> animalHeap = new Heap<>();
        ArrayList<String> animalAL = new ArrayList<>();
        readFile(animalAL, "animals.txt");
        testAdd(animalBST, animalHeap, animalAL);
        testContains(animalBST, animalHeap, animalAL);
        testRemove(animalBST, animalHeap, animalAL);
        System.out.println("\n\nBefore sorting animalAL:");
        System.out.println("BST Height: " + animalBST.height());
        System.out.println("Heap Height: " + animalHeap.height());
        System.out.println("BST is Balanded?: " + animalBST.isBalanced());
        System.out.println("Heap is Balanded?: " + animalHeap.isBalanced());
        animalBST.clear();
        animalHeap.clear();
        java.util.Collections.sort(animalAL);
        for (int i = 0; i < animalAL.size(); i++) {
            String name = animalAL.get(i);
            animalBST.add(name);
            animalHeap.add(name);
        }
        System.out.println("\n\nAfter sorting animalAL:");
        System.out.println("BST Height: " + animalBST.height());
        System.out.println("Heap Height: " + animalHeap.height());
        System.out.println("BST is Balanded?: " + animalBST.isBalanced());
        System.out.println("Heap is Balanded?: " + animalHeap.isBalanced());
    }

    public static void readFile(ArrayList<String> al,
                                String filename) {
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                al.add(read.nextLine());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }

    }

    public static void testAdd(BST<String> bst,
                               Heap<String> heap,
                               ArrayList<String> al) {
        int totalBST = 0;
        int totalHeap = 0;
        int count = 0;
        System.out.println("Testing add");
        System.out.printf("%-30s\t%-10s\t%-10s\n", "Animal Name", "BST Iterations", "Heap Iterations");
        for (int i = 0; i < al.size(); i++) {
            count++;
            String name = al.get(i);
            int bstIter = bst.add(name);
            int heapIter = heap.add(name);
            if(i % 24 == 0){
                System.out.printf("%-30s\t%-10d\t%-10d\n", name, bstIter, heapIter);
                totalBST += bstIter;
                totalHeap += heapIter;
            }
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", "average", totalBST/count, totalHeap/count);
    }

    public static void testContains(BST<String> bst,
                               Heap<String> heap,
                               ArrayList<String> al) {
        int totalBST = 0;
        int totalHeap = 0;
        System.out.println("Testing contains");
        System.out.printf("%-30s\t%-10s\t%-10s\n", "Animal Name", "BST Iterations", "Heap Iterations");
        for (int i = 0; i < 20; i++) {
            int index = (int) (Math.random() * al.size());
            String name = al.get(i);
            int bstIter = bst.contains(name);
            int heapIter = heap.contains(name);
            System.out.printf("%-30s\t%-10d\t%-10d\n", name, bstIter, heapIter);
            totalBST += bstIter;
            totalHeap += heapIter;
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", "average", totalBST/20, totalHeap/20);
    }

    public static void testRemove(BST<String> bst,
                                    Heap<String> heap,
                                    ArrayList<String> al) {
        int totalBST = 0;
        int totalHeap = 0;
        System.out.println("Testing remove");
        System.out.printf("%-30s\t%-10s\t%-10s\n", "Animal Name", "BST Iterations", "Heap Iterations");
        for (int i = 0; i < 20; i++) {
            int index = (int) (Math.random() * al.size());
            String name = al.get(i);
            int bstIter = bst.remove(name);
            int heapIter = heap.remove();
            System.out.printf("%-30s\t%-10d\t%-10d\n", name, bstIter, heapIter);
            totalBST += bstIter;
            totalHeap += heapIter;
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", "average", totalBST/20, totalHeap/20);
    }


}
