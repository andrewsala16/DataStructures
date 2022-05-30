import java.util.Comparator;

public class ComparatorBySecond <E1, E2 extends Comparable<E2>>
        implements Comparator<Pair<E1,E2>> {

    public int compare(Pair<E1, E2> p1,
                       Pair<E1, E2> p2) {
        E2 first1 = p1.getSecond();
        E2 first2 = p2.getSecond();
        return first1.compareTo(first2);
    }
}
