import java.util.ArrayList;

public class Sort {
    public static void selectionSort(int[] list) {
        int minIndex;
        for (int i = 0; i < list.length - 1; i++) {
            int min = list[i];
            minIndex = i;
            for (int j = i; j < list.length; j++) {
                if (list[j] < min) {
                    min = list[j];
                    minIndex = j;
                }
            }
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            //Insert element i in the sorted sub-list
            int currentVal = list[i];
            int j = i;
            while (j > 0 && currentVal < (list[j - 1])) {
                // Shift element (j-1) into element (j)
                list[j] = list[j - 1];
                j--;
            }
            // Insert currentVal at position j
            list[j] = currentVal;
        }
    }

    public static void bubbleSort(int[] list) {
        boolean sorted = false;
        for (int k = 1; k < list.length && !sorted; k++) {
            sorted = true;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    // swap
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void mergeSort(int[] list) {
        if (list.length > 1) { // ==1: base case
            int[] firstHalf = new int[list.length/2];
            int[] secondHalf = new int[list.length - list.length/2];
            System.arraycopy(list, 0, firstHalf, 0, list.length/2);
            System.arraycopy(list, list.length/2, secondHalf, 0, list.length-list.length/2);
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
    }

    public static void merge(int[] list1, int[] list2, int[] list) {
        int list1Index = 0;
        int list2Index = 0;
        int listIndex = 0;
        while (list1Index < list1.length && list2Index < list2.length) {
            if (list1[list1Index] < list2[list2Index])
                list[listIndex++] = list1[list1Index++];
            else
                list[listIndex++] = list2[list2Index++];
        }
        while(list1Index < list1.length)
            list[listIndex++] = list1[list1Index++];
        while(list2Index < list2.length)
            list[listIndex++] = list2[list2Index++];
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length-1);
    }
    public static void quickSort(int[] list,
                                 int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex-1);
            quickSort(list, pivotIndex+1, last);
        }
    }
    public static int partition(int[] list,
                                int first, int last){
        int pivot;
        int index, pivotIndex;
        pivot = list[first];// pivot is the first element
        pivotIndex = first;
        for (index = first + 1;
             index <= last; index++)
            if (list[index] < pivot){
                pivotIndex++;
                swap(list, pivotIndex, index);
            }
        swap(list, first, pivotIndex);
        return pivotIndex;
    }

    public static void swap(int[] list, int i1, int i2){
        int temp = list[i1];
        list[i1] = list[i2];
        list[i2] = temp;
    }
    public static int max(int[] list) {
        int maxValue = 0;
        for (int i : list) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;

    }


    public static void bucketSort(int[] list) {
        int t = max(list);
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(t + 1);
        for (int i = 0; i < t + 1; i++)
            buckets.add(new ArrayList<>());// bucket i
        //Distribute the data on the buckets
        for (int i = 0; i < list.length; i++) {
            ArrayList<Integer> bucket = buckets.get(list[i]);
            bucket.add(list[i]);
        }
        // Move the data from the buckets back to the list
        int k = 0;
        for (int i = 0; i < buckets.size(); i++) {
            ArrayList<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++)
                list[k++] = bucket.get(j);
        }
    }

    public static void radixSort(int[] list) {
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(10);// 10 buckets
        int maxValue = max(list);
        int digits = Integer.toString(maxValue).length();
        for(int d=0; d<digits; d++) {
            for(int j=0; j<10; j++) { // create buckets for iteration d
                buckets.add(new ArrayList<>());
            }
            //Distribute the data on the buckets
            for(int j=0; j<list.length; j++){
                int digit = (list[j] % (int)(Math.pow(10, d+1))) /
                        (int)(Math.pow(10,d));
                ArrayList<Integer> bucket = buckets.get(digit);
                bucket.add(list[j]);
            }
            // Move the data from the buckets back to the list
            int k=0;
            for(int l=0; l<10; l++) {
                ArrayList<Integer> bucket = buckets.get(l);
                for(int j=0; j<bucket.size(); j++)
                    list[k++] = bucket.get(j);
            }
            buckets.clear(); // for next iteration
        }
    }





}
