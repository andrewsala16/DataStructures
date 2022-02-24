public abstract class Shape {
    private String color;

    protected Shape(){
        color = "none";
    }

    protected Shape(String color){
        this.color = color;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
