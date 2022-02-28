import java.util.Comparator;

public class ComparatorByYear implements Comparator<Catalog> {

    @Override
    public int compare(Catalog p1, Catalog p2) {
        Integer y1 = p1.getYear();
        Integer y2 = p2.getYear();
        return y1.compareTo(y2);
    }
}
