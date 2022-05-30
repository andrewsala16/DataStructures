import java.lang.reflect.Array;
import java.util.ArrayList;

public class Sort {

    public static int[] iterations = new int[6];

    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
        int minIndex;
        for (int i = 0; i < list.size() - 1; i++) {
            iterations[0]++;
            E min = list.get(i);
            minIndex = i;
            for (int j = i; j < list.size(); j++) {
                iterations[0]++;
                if (list.get(j).compareTo(min) < 0) {
                    min = list.get(j);
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
        for (int i = 1; i < list.size(); i++) {
            iterations[1]++;
            //Insert element i in the sorted sub-list
            E currentVal = list.get(i);
            int j = i;
            while (j > 0 && currentVal.compareTo(list.get(j-1)) < 0) {
                iterations[1]++;
                // Shift element (j-1) into element (j)
                list.set(j, list.get(j-1));
                j--;
            }
            // Insert currentVal at position j
            list.set(j, currentVal);
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
        boolean sorted = false;
        for (int k = 1; k < list.size() && !sorted; k++) {
            iterations[2]++;
            sorted = true;
            for (int i = 0; i < list.size() - k; i++) {
                iterations[2]++;
                if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                    // swap
                    swap(list, i, (i+1));
                    sorted = false;
                }
            }
        }
    }

    public static <E> ArrayList<E> sublist(ArrayList<E> list, int start, int end) {
        ArrayList<E> sublist = new ArrayList<>();
        for (int i = start; i < end; i++) {
            iterations[3]++;
            sublist.add(list.get(i));
        }
        return sublist;

    }

    public static <E extends Comparable<E>>void mergeSort(ArrayList<E> list) {
        iterations[3]++;
        if (list.size() > 1) { // ==1: base case
            ArrayList<E> firstHalf;
            ArrayList<E> secondHalf;
            firstHalf = sublist(list, 0, list.size()/2);
            secondHalf = sublist(list, list.size()/2, list.size());
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
    }

    public static <E extends Comparable<E>>void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
        int list1Index = 0;
        int list2Index = 0;
        int listIndex = 0;
        while (list1Index < list1.size() && list2Index < list2.size()) {
            iterations[3]++;
            if (list1.get(list1Index).compareTo(list2.get(list2Index)) < 0)
                list.set(listIndex++, list1.get(list1Index++));

            else
                list.set(listIndex++, list2.get(list1Index++));
        }
        while(list1Index < list1.size()) {
            iterations[3]++;
            list.set(listIndex++, list1.get(list1Index++));
        }
        while(list2Index < list2.size()) {
            iterations[3]++;
            list.set(listIndex++, list2.get(list2Index++));
        }
    }

    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
        quickSort(list, 0, list.size()-1);
    }
    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list,
                                 int first, int last) {
        iterations[4]++;
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex-1);
            quickSort(list, pivotIndex+1, last);
        }
    }
    public static <E extends Comparable<E>> int partition(ArrayList<E> list,
                                int first, int last){
        E pivot;
        int index, pivotIndex;
        pivot = list.get(first);// pivot is the first element
        pivotIndex = first;
        for (index = first + 1; index <= last; index++) {
            iterations[4]++;
            if (list.get(index).compareTo(pivot) < 0) {
                pivotIndex++;
                swap(list, pivotIndex, index);
            }
        }
        swap(list, first, pivotIndex);
        return pivotIndex;
    }

    public static <E> void swap(ArrayList<E> list, int i1, int i2){
        E temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    public static <E extends Comparable<E>>void heapSort(ArrayList<E> list) {
        Heap<E> heap = new Heap<>();
        for (int i = 0; i < list.size(); i++) {
            iterations[5]++;
            heap.add(list.get(i));
        }
        for (int i = list.size() - 1; i >= 0 ; i--) {
            iterations[5]++;
            list.set(i, heap.remove());
        }
    }




}