import java.util.Objects;

public class Pair<E1, E2>{
    private E1 first;
    private E2 second;

    public Pair(){
        first = null;
        second = null;
    }

    public Pair(E1 first, E2 second){
        this.first = first;
        this.second = second;
    }

    public E1 getFirst(){
        return first;
    }

    public E2 getSecond() {
        return second;
    }

    public void setFirst(E1 first) {
        this.first = first;
    }

    public void setSecond(E2 second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair<?, ?> ) {
            Pair<E1, E2> p = (Pair<E1, E2>) obj;
            boolean f = this.first.equals(p.first);
            boolean s = this.second.equals(p.second);
            return f && s;

        }
        return false;
    }

}
