import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static final int SIZE = 10000;
    public static void main(String[] args) {
        ArrayList<Integer> randomList = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            randomList.add((int)(Math.random()*(SIZE-1))+1);
        }

        ArrayList<Integer> sortedList = (ArrayList<Integer>) randomList.clone();
        Collections.sort(sortedList);
        
        ArrayList<Integer> reversedList = (ArrayList<Integer>) randomList.clone();
        Collections.reverse(reversedList);

        
        Sort.selectionSort(randomList);

        Collections.shuffle(randomList);
        Sort.insertionSort(randomList);

        Collections.shuffle(randomList);
        Sort.bubbleSort(randomList);

        Collections.shuffle(randomList);
        Sort.mergeSort(randomList);

        Collections.shuffle(randomList);
        Sort.quickSort(randomList);

        Collections.shuffle(randomList);
        Sort.heapSort(randomList);

        Collections.shuffle(randomList);
        Sort.bucketSort(randomList);

        Collections.shuffle(randomList);
        Sort.radixSort(randomList);

        int[] randomIterations = new int[8];

        for (int i = 0; i < Sort.iterations.length; i++) {
            randomIterations[i] = Sort.iterations[i];
        }

        Sort.selectionSort(reversedList);

        Collections.reverse(reversedList);
        Sort.insertionSort(reversedList);

        Collections.reverse(reversedList);
        Sort.bubbleSort(reversedList);

        Collections.reverse(reversedList);
        Sort.mergeSort(reversedList);

        Collections.reverse(reversedList);
        Sort.quickSort(reversedList);

        Collections.reverse(reversedList);
        Sort.heapSort(reversedList);

        Collections.reverse(reversedList);
        Sort.bucketSort(reversedList);

        Collections.reverse(reversedList);
        Sort.radixSort(reversedList);

        int[] reversedIterations = new int[8];

        for (int i = 0; i < Sort.iterations.length; i++) {
            reversedIterations[i] = Sort.iterations[i];
        }



        Sort.selectionSort(sortedList);

        Collections.sort(sortedList);
        Sort.insertionSort(sortedList);

        Collections.sort(sortedList);
        Sort.bubbleSort(sortedList);

        Collections.sort(sortedList);
        Sort.mergeSort(sortedList);

        Collections.sort(sortedList);
        Sort.quickSort(sortedList);

        Collections.sort(sortedList);
        Sort.heapSort(sortedList);

        int[] sortedIterations = new int[8];

        for (int i = 0; i < Sort.iterations.length; i++) {
            sortedIterations[i] = Sort.iterations[i];
        }

        System.out.println("Dataset Size: " + SIZE);

        String[] algorithms = {"Selection Sort", "Insertion Sort", "Bubble Sort",
                "Merge Sort", "Quick Sort", "Heap Sort", "Bucket Sort", "Radix Sort"};

        System.out.printf("%-30s\t%-10s\t%-10s\t%-10s\n", "Sorting Algorithm", "Random", "Sorted", "Reverse");
        for (int i = 0; i < Sort.iterations.length; i++) {
            System.out.printf("%-30s\t%-10s\t%-10s\t%-10s\n", algorithms[i], randomIterations[i], sortedIterations[i], reversedIterations[i]);
        }

        /* As seen in the table the type of sorting method that should be used
        depends on the format of the list being sorted.
        The quadratic sorting algorithms work best on sorted lists while it doesn't
        make much of a difference between random and reverse order.
        Merge sort and heap sort have similar amount of iterations for all three, though
        quick sort has significantly more on sorted and reverse order.
        Linear algorithms have similar performance across all types of lists.

         */


    }
}
