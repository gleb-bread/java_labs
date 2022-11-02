public class Task2 {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(repeat("erterteter", 6));
        System.out.println(differensMaxMin(arr1));
        System.out.println(isAvgWhole(arr1));
        System.out.println(cumulativeSum(arr1));
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(Fibonacci(3));
        System.out.println(isValid("393939"));
        System.out.println(isStrangePair("", "hubris"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(BoxSeq(1));
    }

    public static String repeat(String str0, int n) {
        String str1 = "";
        for (int i = 0; i < str0.length(); i++) {
            String str2 = "";
            for (int j = 0; j < n; j++) {
                str2 += Character.toString(str0.charAt(i));
            }
            str1 += str2;
        }
        return str1;
    }

    public static int differensMaxMin(int[] arr1) {
        int max = arr1[0];
        int min = arr1[0];
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > max) {
                max = arr1[i];
            }
            if (arr1[i] < min) {
                min = arr1[i];
            }
        }
        return max - min;
    }

    public static boolean isAvgWhole(int[] arr1) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }
        if (sum % arr1.length == 0)
            return true;
        else
            return false;
    }

    public static String cumulativeSum(int[] arr1) {
        String str = "[ " + arr1[0];
        for (int i = 0; i < arr1.length - 1; i++) {
            arr1[i + 1] += arr1[i];
            str += " " + arr1[i + 1];
        }
        return str += " ]";
    }

    public static int getDecimalPlaces(String str) {
        int ind = str.lastIndexOf(".");
        if (ind == -1) {
            return 0;
        } else {
            return str.length() - ind - 1;
        }
    }

    public static long Fibonacci(int num) {
        if (num <= 1)
            return num;

        return Fibonacci(num - 1) + Fibonacci(num - 2);

    }

    public static boolean isValid(String code) {
        if (code.matches("[0-9]+")) {
            if (code.length() == 5) {
                for (int i = 0; i < code.length(); i++) {
                    if (code.charAt(i) == ' ') {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean isStrangePair(String str1, String str2) {
        if (str1.equals("") || str2.equals(""))
            return false;
        if (str1.charAt(0) == str2.charAt(str2.length() - 1) && str1.charAt(str1.length() - 1) == str2.charAt(0))
            return true;
        else
            return false;
    }

    private static boolean isPrefix(String wrd, String pref) {

        return wrd.startsWith(pref.substring(0, pref.length() - 2));
    }

    private static boolean isSuffix(String wrd, String suf) {
        return wrd.endsWith(suf.substring(1, suf.length() - 2));
    }

    private static int BoxSeq(int i) {
        if (i == 0) {
            return 0;
        } else if (i % 2 == 0) {
            return BoxSeq(i - 1) - 1;
        } else {
            return BoxSeq(i - 1) + 3;
        }
    }
}