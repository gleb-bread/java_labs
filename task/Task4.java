import java.io.PrintStream;
import java.util.*;

public class Task4 {

    public static void main(String[] args) {
        System.out.println(Bessy(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println(Arrays.toString(split("((()))(())()()(()())")));

        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toCamelCase("isModalOpen"));
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));

        double[] var = new double[] { 16, 18, 30, 1.8 };
        System.out.println(overTime(var));

        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));

        System.out.println(bugger(999));

        System.out.println(toStarShorthand("77777geff"));

        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));

        System.out.println(trouble(666789, 12345667));

        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
    }

    public static String Bessy(int n, int k, String str) {
        String[] text = str.split(" ");
        str = "";
        String finaltxt = "";
        for (int i = 0; i < n; i++) {
            if (str.length() + text[i].length() > k) {
                finaltxt = finaltxt.trim() + "\n" + text[i] + " ";
                str = text[i];
            } else {
                finaltxt += text[i] + " ";
                str += text[i];
            }
        }
        return finaltxt.trim();
    }

    public static String[] split(String str) {
        List<String> list = new ArrayList();
        int f = 0;
        int i = 0;
        while (str.length() > 0) {
            if (str.charAt(i) == '(') {
                ++f;
            } else {
                --f;
            }
            if (f == 0) {
                list.add(str.substring(0, i + 1)); // добавление элемента в начало списка
                str = str.substring(i + 1);
                i = 0;
            } else {
                ++i;
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static String toSnakeCase(String str) {
        for (int i = 0; i < str.length(); ++i) {
            int numOfSymbol = str.charAt(i);
            if (numOfSymbol > 64 && numOfSymbol < 90) {
                str = str.substring(0, i) + "_" + str.substring(i, i + 1).toLowerCase()
                        + str.substring(i + 1, str.length());
            }
        }
        return str;
    }

    public static String toCamelCase(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '_') {
                str = str.substring(0, i) + str.substring(i + 1, i + 2).toUpperCase()
                        + str.substring(i + 2, str.length());
            }
        }
        return str;
    }

    public static String overTime(double[] work) {
        double sum = 0;
        if (17 - work[0] >= 0)
            sum += (17 - work[0]) * work[2];
        if (work[1] - 17 >= 0)
            sum += (work[1] - 17) * work[2] * work[3];
        return ('$' + String.valueOf(sum));
    }

    public static String BMI(String fat0, String fat1) {
        double ves = Double.parseDouble(fat0.split(" ")[0]);
        double rost = Double.parseDouble(fat1.split(" ")[0]);
        String out = " ";
        if (fat0.contains("pounds"))
            ves = ves * 0.45;
        if (fat1.contains("inches"))
            rost *= 0.0254;
        double BMI = Math.round((ves / (rost * rost)) * 10.0) / 10.0;
        if (BMI < 18.5)
            out = BMI + " Underweight";
        if (BMI >= 18.5 && BMI <= 24.9)
            out = BMI + " Normal weight";
        if (BMI > 25)
            out = BMI + " Overweight";
        return out;
    }

    public static int bugger(int num) {
        int count = 0;
        while (num > 9) {
            int chnum = 1;
            while (num > 0) {
                chnum *= num % 10;
                num /= 10;
            }
            num = chnum;
            count++;
        }
        return count;
    }

    public static String toStarShorthand(String str) {
        int count = 0;
        char let = str.charAt(0);
        String newStr = "";
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != let) {
                if (count > 1) {
                    newStr = newStr + let + "*" + count;
                } else {
                    newStr = newStr + let;
                }
                let = str.charAt(i);
                count = 1;
            } else {
                ++count;
            }
        }
        if (count != 1) {
            newStr = newStr + let + "*" + count;
        } else {
            newStr = newStr + let;
        }
        return newStr;
    }

    public static boolean doesRhyme(String str1, String str2) {
        str1 = str1.substring(str1.lastIndexOf(" ") + 1);
        str2 = str2.substring(str2.lastIndexOf(" ") + 1);
        String let = "aeiouyAEIOUY";
        String res1 = "";
        String res2 = "";
        int i;
        for (i = 0; i < str1.length(); ++i) {
            if (let.indexOf(str1.charAt(i)) != -1) {
                res1 = res1 + str1.charAt(i);
            }
        }
        for (i = 0; i < str2.length(); ++i) {
            if (let.indexOf(str2.charAt(i)) != -1) {
                res2 = res2 + str2.charAt(i);
            }
        }
        if (res1.toLowerCase().equals(res2.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean trouble(long a, long b) {
        String aa = Long.toString(a);
        String bb = Long.toString(b);
        int num = 0;
        int i;
        for (i = 2; i < aa.length(); i++) {
            if (aa.charAt(i) == aa.charAt(i - 1) && aa.charAt(i) == aa.charAt(i - 2)) {
                num = aa.charAt(i);
            }
        }
        for (i = 0; i < bb.length(); ++i) {
            if (bb.charAt(i) == num && bb.charAt(i + 1) == num) {
                return true;
            }
        }
        return false;
    }

    public static int countUniqueBooks(String str, char c) {
        Map<Character, Integer> values = new HashMap();
        boolean start = true;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == c && start) {
                ++i;
                for (; str.charAt(i) != c; ++i) {
                    Integer n = (Integer) values.get(str.charAt(i));
                    if (n == null) {
                        values.put(str.charAt(i), 1);
                    } else {
                        values.put(str.charAt(i), n + 1);
                    }
                }
                start = false;
            }
            if (str.charAt(i) == c) {
                start = true;
            }
        }
        return values.size();
    }

}