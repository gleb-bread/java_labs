
public class Task1 {
    public static void main(String[] args) {
        System.out.println(returnNum(' '));

    }

    public static int del(int a, int b) {
        return a % b;
    }

    public static double squareTr(int a, int b) {
        return ((0.5) * a * b);
    }

    public static int anim(int kitch, int cows, int pigs) {
        return kitch * 2 + cows * 4 + pigs * 4;
    }

    public static boolean checkRes(double prod, double prize, double pay) {
        if (prod * prize > pay)
            return true;
        else
            return false;
    }

    public static String checkRes1(int a, int b, int c) {
        if (c == a + b) {
            return "added";
        } else if (c == a - b) {
            return "deducted";
        } else if (c == a / b) {
            return "divided";
        } else if (c == a * b) {
            return "multiplied";
        } else
            return "none";
    }

    public static int returnNum(char a) {
        int charInt = a;
        return charInt;
    }

    public static int returnSum(int last) {
        int sum = 0;
        for (int i = 1; i <= last; i++) {
            sum += i;
        }
        return sum;
    }

    public static int maxLengthTr(int a, int b) {
        return a + b - 1;
    }

    public static int sumKub(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.pow(a[i], 3);
        }
        return sum;
    }

    public static boolean checkDelC(int a, int b, int c) {
        for (int i = 0; i < b; i++) {
            a *= 2;
        }
        if (a % c == 0)
            return true;
        else
            return false;
    }
}
