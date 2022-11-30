public class Primes {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i) == true)
                System.out.println(i);
        }
        int[] arr = new int[] { 234234, 2, 3, 5, 6, 6, 223, 24, 2342, 2342, 12, 233, 4, 127, 188, 129, 135, 144 };
        checkSort(arr);
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += " " + arr[i];
        }
        System.out.println(str);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if ((n % i) == 0)
                return false;
        }
        return true;
    }

    public static int[] checkSort(int[] arr) {
        int x;
        int k;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] - 128 > 32) {
                    if (!(arr[j] - 160 > 32) && !(arr[j] - 160 < 0)) {
                        x = arr[j];
                        if (arr[j] - 160 < arr[i] - 160) {
                            arr[j] = arr[i];
                            arr[i] = x;
                            k = 160;
                        } else {
                            x = arr[arr.length - i - 1];
                            arr[arr.length - i - 1] = arr[i];
                            arr[i] = x;
                        }
                    } else {
                        x = arr[arr.length - i - 1];
                        arr[arr.length - i - 1] = arr[i];
                        arr[i] = x;
                    }
                } else if (!(arr[j] - 128 < 0)) {
                    x = arr[j];
                    if (arr[j] - 128 < arr[i] - 128) {
                        arr[j] = arr[i];
                        arr[i] = x;
                    }
                } else {
                    x = arr[arr.length - i - 1];
                    arr[arr.length - i - 1] = arr[i];
                    arr[i] = x;
                }
            }
        }
        return arr;
    }
}