import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        words.add("hey");
        words.add("slot");
        words.add("Dog");
        System.out.println("List: " + words);
        System.out.println("Size: " + words.size());

        numbers.add(12);
        numbers.add(11);
        System.out.println("Size: " + numbers.size());

        Stack<String> cities = new Stack<>();
        cities.push("NYC");
        cities.push("Houstatlantavegas");
        cities.push("Bethlehem");
        System.out.println("List: " + cities);

        Pair<String, String> country1 = new Pair<>("USA", "Washington DC");
        Pair<String, Integer> student = new Pair<>("Julia Clark", 211216);





    }
}
