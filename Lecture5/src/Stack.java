import java.util.ArrayList;

public class Stack<E>{
    private ArrayList<E> elements;

    public Stack(){
        elements = new ArrayList<>();
    }

    public void push(E item){
        elements.add(item);
    }

    public E pop(){
        E value = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return value;
    }

    public E peek(){
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }
}
