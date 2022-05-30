public class Coordinate {
    private Pair<Integer, Integer> point;

    public Coordinate(int x, int y) {
        point = new Pair<Integer, Integer>(x, y);
    }

    public int getX(){
        return point.getFirst();
    }

    public int getY(){
        return point.getSecond();
    }

    public void setX(int x){
        point.setFirst(x);
    }

    public void setY(int y){
        point.setFirst(y);
    }

    public void translateX(int d){
        point.setFirst(d + point.getFirst());
    }

    public void translateY(int d){
        point.setSecond(d + point.getSecond());
    }

    public void scaleX(int f){
        point.setFirst(f * point.getFirst());
    }

    public void scaleY(int f){
        point.setSecond(f * point.getSecond());
    }

    public String toString() {
        return "(" + point.getFirst() + ", " + point.getSecond() + ")";
    }

    public boolean equals(Object obj) {
        if(obj instanceof Pair) {
            boolean f = this.getX() == point.getFirst();
            boolean s = this.getY() == point.getSecond();
            return f && s;
        }
        return false;
    }








}
