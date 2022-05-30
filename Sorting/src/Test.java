public class Test {
    public static void main(String[] args) {
        int[] list = {67, 33, 21, 84, 49, 50, 75};

        System.out.println("Selection Sort");
        printArray(list);
        Sort.selectionSort(list);
        printArray(list);

        System.out.println("\nInsertion Sort");
        shuffleArray(list);
        printArray(list);
        Sort.insertionSort(list);
        printArray(list);

        System.out.println("\nBubble Sort");
        shuffleArray(list);
        printArray(list);
        Sort.bubbleSort(list);
        printArray(list);

        System.out.println("\nMerge Sort");
        shuffleArray(list);
        printArray(list);
        Sort.mergeSort(list);
        printArray(list);


    }

    public static void printArray(int[] list) {
        System.out.print("[ ");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

    public static void shuffleArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int index = (int)(Math.random() * list.length);
            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }
    }

}
