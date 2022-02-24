public class Rectangle extends Shape{

    double length;
    double width;

    public Rectangle() {
        super();
        length = 0.0;
        width = 0.0;
    }

    public Rectangle(String c, double l, double w){
        super(c);
        this.length = l;
        this.width = w;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return (2*length) + (2*width);
    }
}
