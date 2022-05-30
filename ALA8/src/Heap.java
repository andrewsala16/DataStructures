import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
    private ArrayList<E> list;
    public Heap(){
        list = new ArrayList<>();
    }
    public int size(){ // O(1)
        return list.size();
    }
    public boolean isEmpty(){ // O(1)
        return list.isEmpty();
    }
    public void clear(){ // O(1)
        list.clear();
    }
    public String toString(){ // O(n)
        return list.toString();
    }

    public int contains(E value) { // O(n)
        int iterations = 0;
        for(int i=0; i<list.size(); i++) {
            iterations++;
            if(list.get(i).equals(value))
                return iterations;
        }
        return iterations;
    }

    public int add(E value) { // O()
        int iterations = 0;
        list.add(value); //append value to the heap
        int currentIndex = list.size()-1;
        //index of the  last element
        while(currentIndex > 0) {
            iterations++;
            int parentIndex = (currentIndex-1)/2;
            //swap if current is greater than its parent
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            if(current.compareTo(parent) > 0) {
                list.set(currentIndex, parent);
                list.set(parentIndex, current);
            }
            else
                break; // the tree is a heap
            currentIndex = parentIndex;
        }
        return iterations;
    }

    public int remove() {
        int iterations = 0;
        if(list.size() == 0) return iterations;
        //copy the value of the last node to root
        E removedItem = list.get(0);
        list.set(0, list.get(list.size()-1));
        //remove the last node from the heap
        list.remove(list.size()-1);
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            iterations++;
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            //find the maximum of the left and right nodes
            if (left >= list.size())
                break; // no left child
            int maxIndex = left;
            E max = list.get(maxIndex);
            if (right < list.size()) // right child exists
                if(max.compareTo(list.get(right)) < 0)
                    maxIndex = right;
            // swap if current is less than max
            E current = list.get(currentIndex);
            max = list.get(maxIndex);
            if(current.compareTo(max) < 0){
                list.set(maxIndex, current);
                list.set(currentIndex, max);
                currentIndex = maxIndex;
            }
            else
                break; // the tree is a heap
        }
        return iterations;
    }


    public int height(){
        return height(0);
    }

    public int height(int node){
        if(node >= size()){
            return 0;
        }
        else{
            int hLeft = height(2 * node + 1);
            int hRight = height(2 * node + 2);
            return 1 + Math.max(hLeft, hRight);
        }
    }

    public boolean isBalanced(){
        return isBalanced(0);
    }

    public boolean isBalanced(int node){
        if(node >= size()){
            return true;
        }
        else{
            int hLeft = height(2 * node + 1);
            int hRight = height(2 * node + 2);
            if(Math.abs(hLeft - hRight) > 1){
                return false;
            }
            return isBalanced(2 * node + 1) && isBalanced(2 * node + 2);
        }
    }
}