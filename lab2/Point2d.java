/**
 * Point2d
 */
public class Point2d {
    public static void main(String[] args) {
        Point2d myPoint = new Point2d();
        Point2d myOtherPoint = new Point2d(5, 3);
        Point2d aThirdPoint = new Point2d();
    }

    private double xCoord;
    private double yCoord;

    public Point2d(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    public Point2d() {
        this(0, 0);
    }

    public double getX() {
        return xCoord;
    }

    public double getY() {
        return yCoord;
    }

    public void setX(double val) {
        xCoord = val;
    }

    public void setY(double val) {
        yCoord = val;
    }

}