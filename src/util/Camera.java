package util;

/**
 * Created by Sathvik on 12/4/17.
 */
public class Camera {

    private double x, y;

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void shiftX(double dx) {
        x += dx;
    }

    public void shiftY(double dy) {
        y += dy;
    }
}
