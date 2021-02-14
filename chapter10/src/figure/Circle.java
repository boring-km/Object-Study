package figure;

public class Circle {
    protected static final double PI = 3.14;
    protected final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return PI * Math.pow(radius, 2);
    }

    public double calculatePerimeter() {
        return 2 * PI * radius;
    }
}
