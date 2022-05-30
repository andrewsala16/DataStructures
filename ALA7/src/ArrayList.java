
import java.util.Iterator;
public class ArrayList<E> {
    // data members
    private E[] elements;
    private int size;
    // Constructors
    public ArrayList() {
        elements = (E[]) new Object[10];
        size = 0;
    }
    public ArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
    }

    // Adding an item to the list (2 methods)
    public int add(E item) {
        return add(size, item);
    }

    public int add(int index, E item){
        if(index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        int iterations = ensureCapacity();
        for(int i=size-1; i>=index; i--){
            iterations++;
            elements[i+1] = elements[i];
        }
        elements[index] = item;
        size++;
        return iterations;
    }
    // Getter and Setter
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }
    public E set(int index, E item) {
        checkIndex(index);
        E oldItem = elements[index];
        elements[index] = item;
        return oldItem;
    }
    // Size of the list
    public int size() { return size; }
    // Clear the list
    public void clear() { size = 0; }
    // Check if the list is empty
    public boolean isEmpty() { return (size == 0);}

    // Removing an object from the list
    public int remove(Object o) {
        int iterations = 0;
        E item = (E) o;
        for(int i=0; i<size; i++) {
            iterations++;
            if (elements[i].equals(item)) {
                iterations += remove(i);

            }
        }
        return iterations;
    }
    // Removing the item at index from the list
    public int remove(int index) {
        int iterations = 0;
        checkIndex(index);
        E item = elements[index];
        for(int i=index; i<size-1; i++) {
            iterations++;
            elements[i] = elements[i + 1];
        }
        size--;
        return iterations;
    }
    // Shrink the list to size
    public void trimToSize() {
        if (size != elements.length) {
            E[] newElements = (E[]) new Object[size];
            for(int i=0; i<size; i++)
                newElements[i] = elements[i];
            elements = newElements;
        }
    }
    // Grow the list if needed
    private int ensureCapacity() {
        int iterations = 0;
        if(size >= elements.length) {
            int newCap = (int) (elements.length * 1.5);
            E[] newElements = (E[]) new Object[newCap];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
                iterations++;
            }
            elements = newElements;
        }
        return 0;
    }
    // Check if the index is valid
    private void checkIndex(int index){
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(
                    "Index out of bounds. Must be between 0 and "+
                            (size-1));
    }
    // toString() method
    public String toString() {
        String output = "[";
        for(int i=0; i<size-1; i++)
            output += elements[i] + " ";
        output += elements[size-1] + "]";
        return output;
    }

    // Iterator for the list
    public Iterator<E> iterator(){
        return new ArrayIterator();
    }
    // Inner class that implements Iterator<E>
    private class ArrayIterator implements Iterator<E>{
        private int current = -1;
        public boolean hasNext() { return current < size-1; }
        public E next() { return elements[++current]; }
    }

    public int contains(Object o) {
        Iterator<E> iter = iterator();
        int iterations = 0;
        while(iter.hasNext()){
            iterations++;
            if(iter.next().equals(o)){
                return iterations;
            }
        }
        return iterations;
    }


}
