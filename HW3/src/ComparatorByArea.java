import java.util.Comparator;

public class ComparatorByArea implements Comparator<Coordinate> {

    private double getArea(Coordinate temp){
        double area = (temp.getX() * temp.getY())/2;
        return area;
    }
    public int compare(Coordinate c1, Coordinate c2){
        double a1 = getArea(c1);
        double a2 = getArea(c2);
        if(a1 < a2){
            return -1;
        } else if(a1 > a2){
            return 1;
        }
        return 0;
    }
}
