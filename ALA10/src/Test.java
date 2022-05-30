import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static final int SIZE = 10000;
    public static void main(String[] args) {
        ArrayList<Integer> dataSet = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            dataSet.add((int)(Math.random()*(SIZE-1))+1);
        }

        Sort.selectionSort(dataSet);

        Collections.shuffle(dataSet);
        Sort.insertionSort(dataSet);

        Collections.shuffle(dataSet);
        Sort.bubbleSort(dataSet);

        Collections.shuffle(dataSet);
        Sort.mergeSort(dataSet);

        Collections.shuffle(dataSet);
        Sort.quickSort(dataSet);

        Collections.shuffle(dataSet);
        Sort.heapSort(dataSet);

        System.out.println("DataSet Size: " + SIZE);

        String[] algorithms = {"Selection Sort", "Insertion Sort", "Bubble Sort",
                "Merge Sort", "Quick Sort", "Heap Sort"};

        System.out.printf("%-30s\t%-10s\n", "Sorting Algorithm", "Iterations");
        for (int i = 0; i < Sort.iterations.length; i++) {
            System.out.printf("%-30s\t%-10d\n", algorithms[i], Sort.iterations[i]);
        }


    }
}
