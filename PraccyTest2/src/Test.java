import java.util.Collection;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        // he
    }

    public static <E> void combineNoDuplicates(Collection<E> c1,
                                               Collection<E> c2) {
        Iterator<E> iter = c2.iterator();
        while(iter.hasNext()){
            E temp = iter.next();
            if(!c1.contains(temp)){
                c1.add(temp);
            }
        }
    }

    public static <E> void recursiveCombineNoDuplicates(Collection<E> c1,
                                                        Collection<E> c2) { // O(n^2)
        Iterator<E> iter = c2.iterator();
        recursiveCombineNoDuplicates(c1, iter);
    }

    public static <E> void recursiveCombineNoDuplicates(Collection<E> c1,
                                               Iterator<E> iter) { // O(n^2)
        if(iter.hasNext()){
            E temp = iter.next();
            if(!c1.contains(temp)){
                c1.add(temp);
            }
            recursiveCombineNoDuplicates(c1, iter);
        }
    }

    public static <E> boolean search(Collection<E> c, E key) {
        Iterator<E> iter = c.iterator();
        return search(iter, key);
    }

    public static <E> boolean search(Iterator<E> iter, E key) {
        if(iter.hasNext()){
            if(iter.next().equals(key)){
                return true;
            }
            else{
                search(iter, key);
            }
        }
        return false;
    }
}
