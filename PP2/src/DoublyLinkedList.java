import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * Implementation of DoublyLinkedList.java using the interface list
 * @author Andrew Sala
 * @version 1.0
 * Date of creation: April 5, 2022
 * Last Date Modified: April 17, 2022
 **/
public class DoublyLinkedList<E> implements List<E> {
    // Data members
    private Node head, tail;
    int size;

    /**
     * Inner class Node
     **/
    private class Node {
        E value;
        Node previous;
        Node next;

        Node(E initialValue) {
            value = initialValue;
        }
    }

    // Constructor
    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    // Adding an item to the list
    public boolean addFirst(E item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        size++;
        return true;
    }

    public boolean add(E item) {
        return addFirst(item);
    }

    // Retrieving an item from the list
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }

    public E getLast() {
        if (head == null)
            throw new NoSuchElementException();
        return tail.value;
    }

    // Removing an item from the list
    public boolean removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null){
            tail = null;
        }
        else{
            head.next.previous = null;
        }
        head = head.next;
        size--;
        return true;
    }

    public boolean removeLast() {
        if (tail == null){
            throw new NoSuchElementException();
        }
        if (head.next == null) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        size--; 
        return true;
    }

    // toString() method
    public String toString() {
        String output = "[";
        Node node = head;
        while (node != null) {
            output += node.value + " ";
            node = node.next;
        }
        output += "]";
        return output;
    }

    // clear, check if empty, and size of the list
    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    // Implementing an iterator for the list
    public ListIterator<E> listIterator(){
        return new DoublyLinkedListIterator();
    }

    public ListIterator<E> listIterator(int index){
        if(index == size()) {
            return new DoublyLinkedListIterator(size - 1);
        }
        else if(index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return new DoublyLinkedListIterator(index);
    }




    private class DoublyLinkedListIterator<E> implements ListIterator<E> {

        private Node current = head;

        public DoublyLinkedListIterator() {
            current = head;
        }

        public DoublyLinkedListIterator(int index) {
            current = head;
            int i = 0;
            while(i < index) {
                current = current.next;
                i++;
            }
        }

        public boolean hasNext() {
            return current.next != null;
        }

        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E value = (E) current.value;
            current = current.next;
            return value;
        }

        public boolean hasPrevious() {
            return (current != null);
        }

        public E previous() {
            if(!hasPrevious()) {
                throw new NoSuchElementException();
            }
            Node temp = head;
            Node previous = null;
            while(temp != current) {
                previous = temp;
                temp = temp.next;
            }
            E value = (E) current.value;
            current = previous;
            return value;
        }

        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        public void add(E e) {
            throw new UnsupportedOperationException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


    }

}
