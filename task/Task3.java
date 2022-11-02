public class Task3 {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 3, 4, 4, 4, 5 };
        int[] arr2 = new int[] { 2, 5, 7 };
        System.out.println(solutions(1, 0, 0));
        System.out.println(FindZip("all zip files are zipped")); // no
        System.out.println(checkPerfect(6));
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(same(arr1, arr2));
        // System.out.println(isKaprekar(3));
        System.out.println(longestZero("01100001011000")); // no
        // System.out.println(nextPrime(12));
        System.out.println(rightTriangle(70, 130, 110)); // ok
    }

    public static int solutions(double a, double b, double c) {
        if (Math.pow(b, 2) - 4 * a * c < 0) {
            return 0;
        } else if (Math.pow(b, 2) - 4 * a * c == 0) {
            return 1;
        } else
            return 2;
    }

    public static int FindZip(String str) {
        int count = 0;
        int index = -1;
        for (int i = 1; i < str.length() - 1; i++) {
            String smallstr = "";
            smallstr += str.charAt(i - 1) + str.charAt(i) + str.charAt(i);
            if (smallstr.toLowerCase() == "zip" && count == 0) {
                count++;
            } else if (smallstr.toLowerCase() == "zip" && count < 2) {
                index = i - 1;
                return index;
            }
        }
        return index;
    }

    public static boolean checkPerfect(int num) {
        int num1 = 0;
        for (int i = 1; i < num; i++) {
            num1 += i;
        }
        if (num1 != num)
            return false;
        else
            return true;
    }

    public static String flipEndChars(String str) {
        String str1 = "";
        str1 += str.charAt(0);
        if (str.length() <= 2)
            return "Incompatible.";
        else if (str.charAt(0) == str.charAt(str.length() - 1))
            return "Two's a pair.";
        for (int i = 1; i < str.length() - 1; i++) {
            str1 += str.charAt(i);
        }
        str1 += str.charAt(str.length() - 1);
        return str1;
    }

    public static boolean isValidHexCode(String str) {
        if (str.charAt(0) != '#') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            int numOfSymbol = str.charAt(i);
            if (numOfSymbol < 48 && numOfSymbol > 70) {
                if (numOfSymbol > 57 && numOfSymbol < 65) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean same(int[] arr1, int[] arr2) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int[] arr3 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
            for (int j = 0; j < arr3.length; j++) {
                if (arr3[i] == arr1[i]) {
                    count0++;
                }
            }
            if (count0 == 1) {
                count1++;
            }
        }
        count0 = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr3[i] = arr2[i];
            for (int j = 0; j < arr3.length; j++) {
                if (arr3[i] == arr2[i]) {
                    count0++;
                }
            }
            if (count0 == 1) {
                count2++;
            }
        }
        if (count1 == count2)
            return true;
        else
            return false;
    }

    public static boolean isKaprekar(int num) {
        double left = 0;
        double n = Math.pow(num, 2);
        String str = "";
        String leftNum = "";
        String rightNum = "";
        str += n;
        left = Math.floor(str.length() / 2);
        for (int i = 0; i < left; i++) {
            leftNum += str.charAt(i);
        }
        for (int i = (int) left - 1; i < str.length(); i++) {
            rightNum += str.charAt(i);
        }
        int sum = Integer.parseInt(leftNum) + Integer.parseInt(rightNum);
        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

    public static String longestZero(String str) {
        int count = 0;
        int max = 0;
        int index = 0;
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    index = i;
                }
                count = 0;
            }
        }
        if (max == 0) {
            return str2;
        } else {
            for (int i = 0; i < max; i++) {
                str2 += str.charAt(index - i);
            }
        }
        return str2;
    }

    public static int nextPrime(int num) {
        for (int i = 2; i < num; i++) {
            if ((num % i) == 0)
                nextPrime(num++);
        }
        return num;
    }

    public static boolean rightTriangle(int a, int b, int c) {
        double max = a;
        int index = 1;
        if (max < b) {
            max = b;
            index = 2;
        }

        if (max < c) {
            max = c;
            index = 3;
        }
        if ((Math.pow(max, 2) == Math.pow(b, 2) + Math.pow(c, 2)) && index == 1) {
            return true;
        }
        if ((Math.pow(max, 2) == Math.pow(a, 2) + Math.pow(c, 2)) && index == 2) {
            return true;
        }
        if ((Math.pow(max, 2) == Math.pow(b, 2) + Math.pow(a, 2)) && index == 3) {
            return true;
        }
        return false;
    }
}
