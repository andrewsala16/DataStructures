/**
 * 
 * @author houdghiri
 *
 * @param <E1> generic type of the first element of the pair
 * @param <E2> generic type of the second element of the pair
 */ 
public class Pair<E1, E2> {
	// Data members first and second
	private E1 first;
	private E2 second;
	/**
	 *  Default constructor
	 */
	public Pair() {
		first = null; second = null;
	}
	/**
	 * Constructor with two arguments
	 * @param first value to initialize the data member first
	 * @param second value to initialize the data member second
	 */
	public Pair(E1 first, E2 second) {
		this.first = first;
		this.second = second;
	}
	/**
	 * getter for the data member first
	 * @return value of first
	 */
	public E1 getFirst() {
		return first;
	}
	/**
	 * getter for the data member second
	 * @return value of second
	 */
	public E2 getSecond() {
		return second;
	}
	/**
	 * setter for the data member first
	 * @param f value to set first
	 */
	public void setFirst(E1 f) {
		first = f;
	}
	/**
	 * setter for the data member second
	 * @param s value to set second
	 */
	public void setSecond(E2 s) {
		second = s;
	}
	/**
	 * returns the two data members between parentheses as a string
	 */
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	/**
	 * Method equals for type Pair
	 * returns true if two pairs are identical
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Pair) {
			Pair<E1, E2> p = (Pair) obj;
			boolean f = this.first.equals(p.first);
			boolean s = this.second.equals(p.second);
			return f && s;
		}
		return false;
	}
}