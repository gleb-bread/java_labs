
public class Point3d extends Point2d {

    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3d(double x, double y, double z) {
        super(x, y);
        zCoord = z;
    }

    public Point3d() {
        this(0, 0, 0);
    }

    public double getZ() {
        return zCoord;
    }

    public void setZ(double val) {
        zCoord = val;
    }

    public double distanceTo(Point3d num) {
        return (Math.sqrt(Math.pow((num.getX() - xCoord), 2) + Math.pow((num.getY() - yCoord), 2)
                + Math.pow((num.getZ() - zCoord), 2)));
    }

    public static String checkPoints(Point3d num1, Point3d num2) {
        String str = "";
        if (num1.getX() > num2.getX()) {
            str += "Coord x in first obj  is larger,";
        } else {
            str += "Coord x in first obj  is smaller,";
        }
        if (num1.getY() > num2.getY()) {
            str += " Coord y in first obj  is larger,";
        } else {
            str += " Coord y in first obj  is smaller,";
        }
        if (num1.getZ() > num2.getZ()) {
            str += " Coord z in first obj  is larger.";
        } else {
            str += " Coord z in first obj  is smaller.";
        }
        return str;
    }
}
