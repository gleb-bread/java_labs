public class Pcalindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s) == true)
                System.out.println(reverseString(s) + ' ' + isPalindrome(s));
        }
    }

    public static String reverseString(String s) {
        String str = "";
        for (int i = s.length() - 1; i >= 0; --i)
            str += s.charAt(i);
        return str;
    }

    public static boolean isPalindrome(String s) {
        String str = reverseString(s);
        return s.equals(str);
    }
}
