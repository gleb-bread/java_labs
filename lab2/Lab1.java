import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Point3d coord1 = new Point3d();
        Point3d coord2 = new Point3d();
        Point3d coord3 = new Point3d();
        System.out.println("Введите координаты Х для 1 точки:");
        coord1.setX(scn.nextDouble());
        System.out.println("Введите координаты Y для 1 точки:");
        coord1.setY(scn.nextDouble());
        System.out.println("Введите координаты Z для 1 точки:");
        coord1.setZ(scn.nextDouble());

        System.out.println("Введите координаты Х для 2 точки:");
        coord2.setX(scn.nextDouble());
        System.out.println("Введите координаты Y для 2 точки:");
        coord2.setY(scn.nextDouble());
        System.out.println("Введите координаты Z для 2 точки:");
        coord2.setZ(scn.nextDouble());

        System.out.println("Введите координаты Х для 3 точки:");
        coord3.setX(scn.nextDouble());
        System.out.println("Введите координаты Y для 3 точки:");
        coord3.setY(scn.nextDouble());
        System.out.println("Введите координаты Z для 3 точки:");
        coord3.setZ(scn.nextDouble());
        scn.close();
        System.out.println(String.format("%.2f", coord1.distanceTo(coord2)));
        if (!(checkPoints(coord1, coord2, coord3) == false))
            System.out.println(computeArea(coord1, coord2, coord3));
        else
            System.out.println("Координаты одинаковы");

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