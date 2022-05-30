import java.util.ListIterator;
/**
 * Interface used to define ListIterator
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: April 5, 2022
 * Last Date Modified: April 17, 2022
 */
public interface List<E> {
    boolean add(E value);
    int size();
    ListIterator<E> listIterator();
    ListIterator<E> listIterator(int index);
}
