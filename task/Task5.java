
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.StringJoiner;

public class Task5 {

    public static void main(String[] args) {
        System.out.println("----1----");
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(new int[] { 72, 33, -73, 84, -12, -3, 13, -13, -68 }));
        System.out.println(Arrays.toString(encrypt("Sunshine")));
        System.out.println("----2----");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));
        System.out.println("----3----");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.println("----4----");
        System.out.println(sumDigProd(16, 28));
        System.out.println(sumDigProd(0));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println("----5----");
        System.out.println(Arrays.toString(sameVowelGroup(new String[] { "toe", "ocelot", "maniac" })));
        System.out.println(
                Arrays.toString(sameVowelGroup(new String[] { "many", "carriage", "emit", "apricot", "animal" })));
        System.out.println(Arrays.toString(sameVowelGroup(new String[] { "hoops", "chuff", "bot", "bottom" })));
        System.out.println("----6----");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));
        System.out.println("----7----");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(126));
        System.out.println(numToEng(909));
        System.out.println("----8----");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash("Hey dude!"));
        System.out.println("----9----");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.println("----10----");
        System.out.println(hexLattice(19));
    }

    private static int[] encrypt(String s) {
        char lastAscii = 0;
        int[] cryphre = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            cryphre[i] = chars[i] - lastAscii;
            lastAscii = chars[i];
        }
        return cryphre;
    }

    private static String decrypt(int[] s) {
        char lastAscii = 0;
        char[] chars = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            chars[i] = (char) (lastAscii + s[i]);
            lastAscii = chars[i];
        }
        return new String(chars);
    }

    private static boolean canMove(String figure, String from, String to) {
        final String HORSE = "Horse";
        final String BISHOP = "Bishop";
        final String QUEEN = "Queen";
        final String ROOK = "Rook";
        final String PAWN = "Pawn";
        final String KING = "King";
        char fromX = from.charAt(0);
        int fromY = Integer.parseInt(String.valueOf(from.charAt(1)));
        char toX = to.charAt(0);
        int toY = Integer.parseInt(String.valueOf(to.charAt(1)));
        if ((fromY == toY && fromX != toX) || (fromY != toY && fromX == toX)) {
            if (figure.equals(QUEEN) || figure.equals(ROOK)) {
                return true;
            }
            if ((fromY == toY && Math.abs(fromX - toX) == 1) || (fromX == toX && Math.abs(fromY - toY) == 1)) {
                if (figure.equals(KING)) {
                    return true;
                }
            }
            if (fromX == toX && toY - fromY == 1) {
                return figure.equals(PAWN);
            }
        } else if (Math.abs(fromX - toX) == Math.abs(fromY - toY)) {
            if (figure.equals(QUEEN) || figure.equals(BISHOP)) {
                return true;
            }
            if (Math.abs(fromX - toX) == 1) {
                return figure.equals(KING);
            }
        } else if ((Math.abs(fromX - toX) == 1 && Math.abs(fromY - toY) == 2)
                || (Math.abs(fromY - toY) == 1 && Math.abs(fromX - toX) == 2)) {
            return figure.equals(HORSE);
        }
        return false;
    }

    private static boolean canComplete(String s1, String s2) {
        int s1Iterator = 0;
        for (int s2Iterator = 0; s2Iterator < s2.length(); s2Iterator++) {
            if (s1.charAt(s1Iterator) == s2.charAt(s2Iterator)) {
                s1Iterator++;
                if (s1Iterator == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int sumDigProd(int... a1) {
        class Multiplier {
            int getMultipleOfNumbers(long d) {
                int mult = 1;
                while (d > 0) {
                    mult *= (int) (d % 10);
                    d /= 10;
                }
                return mult;
            }
        }

        int newA = 0;
        for (int a : a1) {
            newA += a;
        }
        Multiplier multiplier = new Multiplier();
        while (newA >= 10) {
            newA = multiplier.getMultipleOfNumbers(newA);
        }
        return newA;
    }

    private static String[] sameVowelGroup(String[] words) {
        Set<Character> vowels = new HashSet<>();
        String first = words[0].replaceAll("[qwrtpsdfghjklzxcvbnm]", "");
        for (char c : first.toCharArray()) {
            vowels.add(c);
        }
        ArrayList<String> resultWords = new ArrayList<>();
        resultWords.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            Set<Character> currentVowels = new HashSet<>();
            String it = words[i].replaceAll("[qwrtpsdfghjklzxcvbnm]", "");
            for (char c : it.toCharArray()) {
                currentVowels.add(c);
            }
            if (currentVowels.equals(vowels)) {
                resultWords.add(words[i]);
            }
        }
        return resultWords.toArray(new String[] {});
    }

    private static boolean validateCard(Long number) {
        if (number < Math.pow(10, 14) || number >= Math.pow(10, 19)) {
            return false;
        }
        int controlNum = (int) (number % 10);
        String num = number.toString();
        num = num.substring(0, num.length() - 1);
        int sum = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int doubledInteger = Integer.parseInt(num.substring(i, i + 1));
            if ((num.length() - i) % 2 == 1) {
                doubledInteger *= 2;
                if (doubledInteger > 9) {
                    doubledInteger = doubledInteger % 10 + (doubledInteger / 10) % 10;
                }
            }
            sum += doubledInteger;
        }
        return (10 - (sum % 10)) == controlNum;
    }

    private static String numToEng(int number) {
        class NumTransformer {
            String oneNumberToString(int n) {
                switch (n) {
                    case 1:
                        return "one";
                    case 2:
                        return "two";
                    case 3:
                        return "three";
                    case 4:
                        return "four";
                    case 5:
                        return "five";
                    case 6:
                        return "six";
                    case 7:
                        return "seven";
                    case 8:
                        return "eight";
                    case 9:
                        return "nine";
                    default:
                        return null;
                }
            }

            String decToString(int decCount) {
                switch (decCount) {
                    case 2:
                        return "twenty";
                    case 3:
                        return "thirty";
                    case 4:
                        return "forty";
                    case 5:
                        return "fifty";
                    case 6:
                        return "sixty";
                    case 7:
                        return "seventy";
                    case 8:
                        return "eighty";
                    case 9:
                        return "ninety";
                    default:
                        return null;
                }
            }

            String dec1ToString(int n) {
                switch (n) {
                    case 0:
                        return "ten";
                    case 1:
                        return "eleven";
                    case 2:
                        return "twelve";
                    case 3:
                        return "thirteen";
                    case 4:
                        return "fourteen";
                    case 5:
                        return "fifteen";
                    case 6:
                        return "sixteen";
                    case 7:
                        return "seventeen";
                    case 8:
                        return "eighteen";
                    case 9:
                        return "nineteen";
                    default:
                        return null;
                }
            }
        }
        int hundred = (number / 100) % 10;
        int dec = (number / 10) % 10;
        int n = number % 10;

        NumTransformer numTransformer = new NumTransformer();
        String hundredString = numTransformer.oneNumberToString(hundred);
        String nString = null;
        String decString;
        if (dec != 1) {
            nString = numTransformer.oneNumberToString(n);
            if (n == 0) {
                nString = "zero";
            }
            decString = numTransformer.decToString(dec);
        } else {
            decString = numTransformer.dec1ToString(n);
        }
        StringJoiner joiner = new StringJoiner(" ");
        if (hundredString != null) {
            joiner.add(hundredString);
            joiner.add("hundred");
        }
        if (decString != null) {
            joiner.add(decString);
        }
        if (nString != null) {
            joiner.add(nString);
        }
        return joiner.toString();
    }

    private static String getSha256Hash(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private static String correctTitle(String s) {
        String[] words = s.toLowerCase(Locale.ROOT).split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : words) {
            if (!word.equals("of") && !word.equals("in") && !word.equals("and") && !word.equals("the")) {
                word = word.substring(0, 1).toUpperCase(Locale.ROOT) + word.substring(1);
            }
            joiner.add(word);
        }
        return joiner.toString();
    }

    public static String hexLattice(int n) {
        String picture = "";
        int dottNum = 1;
        int numCycle = 1;
        while (dottNum < n) {
            dottNum = dottNum + (numCycle * 6);
            numCycle++;
        }
        if (dottNum != n)
            return "Invalid";
        for (int i = numCycle; i <= 2 * numCycle - 1; i++) {
            picture += repeat(" ", 2 * numCycle - i);
            for (int j = 0; j < i; j++) {
                picture += " o";
            }
            picture += "\n";
        }
        for (int i = 2 * numCycle - 2; i >= numCycle; i--) {
            picture += repeat(" ", 2 * numCycle - i);
            for (int j = 0; j < i; j++) {
                picture += " o";
            }
            picture += "\n";
        }
        return picture;
    }

    public static String repeat(String string, int n) {
        String ans = "";
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < n; j++) {
                ans += string.charAt(i);
            }
        }
        return ans;
    }

}