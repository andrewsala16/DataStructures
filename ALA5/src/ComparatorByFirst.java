import java.util.Comparator;

public class ComparatorByFirst <E1 extends Comparable<E1>, E2>
        implements Comparator<Pair<E1,E2>> {

    public int compare(Pair<E1, E2> p1,
                       Pair<E1, E2> p2) {
        E1 first1 = p1.getFirst();
        E1 first2 = p2.getFirst();
        return first1.compareTo(first2);
    }
}
