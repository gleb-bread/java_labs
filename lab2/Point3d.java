public class Point3d {
    public static void main(String[] args) {
        Point3d num1 = new Point3d(1, 2, 3);
        Point3d num2 = new Point3d(0, 5, 1);
        Point3d num3 = new Point3d(11.88, 22.56, 16.3);
        String str = checkPoints(num1, num2);
        System.out.println(str);
        System.out.println("Растояние между двумя точками равно = " + String.format("%.2f", num1.distanceTo(num3)));
    }

    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d() {
        this(0, 0, 0);
    }

    public double getX() {
        return xCoord;
    }

    public double getY() {
        return yCoord;
    }

    public double getZ() {
        return zCoord;
    }

    public void setX(double val) {
        xCoord = val;
    }

    public void setY(double val) {
        yCoord = val;
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
