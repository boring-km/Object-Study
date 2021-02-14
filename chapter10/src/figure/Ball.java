package figure;

public class Ball extends Circle {

    public Ball(double radius) {
        super(radius);
    }

    public double calculateSurfaceArea() {
        return 4 * PI * Math.pow(super.radius, 2);
    }

}
