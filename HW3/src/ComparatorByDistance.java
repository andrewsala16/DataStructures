import java.util.Comparator;

public class ComparatorByDistance implements Comparator<Coordinate>{
    private double getDistance(Coordinate temp){
        double a, b, c;
        a = temp.getX();
        b = temp.getY();
        c = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
        return c;
    }
    public int compare(Coordinate c1, Coordinate c2){
        double d1 = getDistance(c1);
        double d2 = getDistance(c2);
        if(d1 < d2) {
            return -1;
        }
        else if(d1 > d2) {
            return 1;
        }
        return 0;
    }
}
