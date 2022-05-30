import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		System.out.println("Part 1");
		// points is an arraylist of coordinates
		ArrayList<Coordinate> points;
		points = new ArrayList<>();
		Coordinate p;
		// adding ten points to the arraylist with random coordinates
		for(int i=0; i<10; i++) {
			int x = (int) (Math.random() * 100);
			int y = (int) (Math.random() * 100);
			p = new Coordinate(x, y);
			points.add(p);
		}
		System.out.println("Original list of points:");
		System.out.println(points);
		for(int i=0; i<points.size(); i++) {
			points.get(i).scaleX((int) (Math.random() * 5)+1);
			points.get(i).scaleY((int) (Math.random() * 10)+1);
		}
		// Scale all the points using a random factor for X and Y
		System.out.println("\n");
		System.out.println("Updated list of points (scale x and y):");
		System.out.println(points);
		for(int i=0; i<points.size(); i++) {
			points.get(i).translateX((int) (Math.random() * 5)+1);
			points.get(i).translateY((int) (Math.random() * 10)+1);
		}
		// Translate all the points using a random distance for X and Y
		System.out.println("\n");
		System.out.println("Updated list of points (translate x and y):");
		System.out.println(points);

		// sort the points using their distance from the origin
		points.sort(new ComparatorByDistance());
		System.out.println("\n");
		System.out.println("Sorted list of points (by distance to the origin):");
		System.out.println(points);

		// sort the points using the area below the line that
		// connects the point to the origin
		points.sort(new ComparatorByArea());
		System.out.println("\n");
		System.out.println("Sorted list of points (by area from origin):");
		System.out.println(points);

		System.out.println("\n\nPart 2\n");
		// 2D Array with the names of townships around Bethlehem
		// Each city has a coordinate in the array (row, column)
		String[][] names = {
				{"Tamaqua","Lehighton" ,"Danielsville" ,"Liberty" , "Hope"},
				{"Kempton", "Northampton", "Nazareth", "Lopatcong", "Washington"},
				{"Hamburg", "Allentown", "Bethlehem", "Easton", "Stewatsville"},
				{"Bernville", "Emmaus", "Hellertown", "Milford", "Alexandria"},
				{"Reading", "BoyerTown","Herleysville","Doylestown", "New Hope"  },
		};
		// Instantiate the class Grid for type String
		// Initialize the grid by passing the 2D array of towns to
		// the third constructor of the class Grid
		Grid<String> map = new Grid<>(names);

		// call paths to determine the number of paths from
		// Northhampton (cell at coordinate (1, 1)) to
		// Alexandria (cell at coordinate  (3, 4))
		int path = paths(map, new Coordinate(1, 1), new Coordinate(3, 4));
		System.out.println("There are " + path + " paths from NorthHampton to Alexandria");

		// call onePath to determine one path from
		// Tamaqua (cell at coordinate (0, 0)) to
		// Milford (cell at coordinate  (3, 3))
		String pa = onePath(map, new Coordinate(0, 0), new Coordinate(3, 3));
		System.out.println("\nOne path from Tamaqua to Milford : Tamaqua" + pa);

	}
	/**
	 * Recursive method to count the number of paths
	 * from the cell at coordinate start
	 * to the cell at coordinate end
	 * Only right and down movements are allowed in the grid
	 * @param <E> generic type of the cells in the grid
	 * @param grid 2D arraylist
	 * @param start (row, col) of the starting point in the grid
	 * @param end (row, col) of the destination point in the grid
	 * @return number of possible paths from start to end
	 */
	public static <E> int paths(Grid<E> grid, Coordinate start, Coordinate end) {
		int countPath = 0;
		return countPath;
	}
	/**
	 * Recursive method to find one path
	 * from the cell at coordinate start
	 * to the cell at coordinate end
	 * Only right and down movements are allowed in the grid
	 * @param <E> generic type of the cells in the grid
	 * @param grid 2D arraylist
	 * @param start (row, col) of the starting point in the grid
	 * @param end (row, col) of the destination point in the grid
	 * @return one path from start to end as a string
	 *         with the contents of the visited cells
	 */
	public static <E> String onePath(Grid<E> grid, Coordinate start, Coordinate end) {
		String path = "";
		return path;
	}

}
