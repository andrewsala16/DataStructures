public class Circle extends Shape{

    private double radius;

    public Circle(){
        super();
        radius = 1.0;
    }

    public Circle(String c, double r){
        super(c);
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
