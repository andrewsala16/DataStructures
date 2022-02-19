/**
 * Class to model Employee diagram; derived class
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: Februray 3, 2021
 * Last Date Modified: Februrary 3, 2021
 */
public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Person("Helen Brown", "222 10th Street Bethlehem", "610-334-2288", "hbrown@gmail.com");
        people[1] = new Student("Paul Leister", "972 4th Street Allentown", "610-331-7177", "pleister@gmail.com", 12345, "CSE");
        people[2] = new Employee("Beth Down", "234 Main Street Philadelphia", "484-222-4433", "bdown@gmail.com", 33442, "Systems Administrator", 75000.0);
        people[3] = new Faculty("Mark Jones", "21 Orchid Street Bethlehem", "610-333-2211", "mjones@gmail.com", 22222, "Faculty", 90000.0, "Associate Professor");
        System.out.println("Original List: ");
        printArray(people);
        sortArray(people);
        System.out.println("Sorted List: ");
        printArray(people);

    }

    /**
     * @param arr to pass array to be printed
     */
    public static void printArray(Person[] arr){
        for (Person p : arr) {
            System.out.println(p);
        }
    }

    /**
     * @param arr to pass array to be sorted
     */
    public static void sortArray(Person[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j].getName().compareTo(arr[minIndex].getName()) < 0){
                    minIndex = j;
                }
            }
            Person temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }




}
