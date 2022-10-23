public class Lab1 {

    public static void main(String[] args) {
        String str = "";
        double[] arr = new double[9];
        int j = 0;
        for (int i = 0; i < args.length; i++) {
            str += args[i];
            arr[j] = (str.charAt(0));
            j += 1;
            arr[j] = str.charAt(1);
            j += 1;
            arr[j] = str.charAt(2);
            j += 1;
            str = "";
        }
        Point3d num1 = new Point3d(arr[0], arr[1], arr[2]);
        Point3d num2 = new Point3d(arr[3], arr[4], arr[5]);
        Point3d num3 = new Point3d(arr[6], arr[7], arr[8]);
        if (checkPoints(num1, num2, num3) == false)
            System.out.println("У вас совпадают точки");
        else
            System.out.println("Площадь треугольника равна " + computeArea(num1, num2, num3));
    }

    public static double computeArea(Point3d num1, Point3d num2, Point3d num3) {
        double a = num1.distanceTo(num2);
        double b = num1.distanceTo(num3);
        double c = num2.distanceTo(num3);
        double p = a + b + c;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static boolean checkPoints(Point3d num1, Point3d num2, Point3d num3) {
        boolean result1 = checkPoint(num1, num2);
        boolean result2 = checkPoint(num1, num3);
        boolean result3 = checkPoint(num2, num3);
        if ((result1 == false) && (result2 == false) && (result3 == false))
            return false;
        else
            return true;
    }

    public static boolean checkPoint(Point3d num1, Point3d num2) {
        if ((num1.getX() == num2.getX()) && (num1.getY() == num2.getY()) && (num1.getZ() == num2.getZ()))
            return false;
        else
            return true;
    }
}