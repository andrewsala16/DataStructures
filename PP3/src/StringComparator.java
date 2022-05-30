import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        String three1 = s1.substring(0, 3);
        String three2 = s2.substring(0, 3);
        return three1.compareTo(three2);
    }
}
