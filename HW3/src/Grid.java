import java.util.ArrayList;

public class Grid<E> {
    private ArrayList<ArrayList<E>> cells;
    private int rows;
    private int cols;

    public Grid() {
        ArrayList[][] cells = new ArrayList[10][10];
    }

    public Grid(int r, int c){
        ArrayList[][] cells = new ArrayList[r][c];
    }

    public Grid(E[][] array){
        ArrayList[][] cells = new ArrayList[array.length][array.length];

    }
}
