import java.util.*;
import java.util.stream.*;

public class repunit extends Thread {
    private static final List<Integer> list = IntStream.range(2, 1200000).boxed().collect(Collectors.toList());;
    
    public static String R(int k) {
        return new String(new char[k]).replace("\0", "1");
    }

    public static int A(int n) {
        for (int i: list) {
            if (longDivisionReminder(i, n) == 0) {
                return i;
            }
        }
        return 0;
        //return list.stream().filter(i -> longDivisionReminder(i, n) == 0).findFirst().orElse(0);
    }

    private static int findLengthOfInteger(int number) {
        int length = 1;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 10000;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number >= 10) {
            length += 1;
        }
        return length;
    }

    public static int longDivisionReminder(int i, int divisor) {
        int length = findLengthOfInteger(divisor);
        int carry = (int) Math.pow(10, length) + Integer.parseInt("1".repeat(length));
        while (length < i - 1) {
            carry = (carry * 10 + 1) % divisor;
            length++;
        }
        return carry;
    }

    public static void main(String[] args) {
        repunit thread = new repunit();
        thread.start();
        int k = 0;
        int n = 999999;
        while (k < 1000000) {
            n = n + 2;
            if (n % 5 == 0) {
                continue;
            } else if (n % 10 == 3 || n % 10 == 7) {
                System.out.println("This is n:" + n);
                k = A(n);
            }
        }
        System.out.println("Le thread parent l'a trouvé! C'est k = " + k + " et n = " + n);
        
    }

    public void run() {
        int k = 0;
        int n = 999999;
        while (k < 1000000) {
            n = n + 2;
            if (n % 5 == 0) {
                continue;
            } else if (n % 10 == 1 || n % 10 == 9) {
                System.out.println("This is n:" + n);
                k = A(n);
            }
        }
        System.out.println("Le thread enfant l'a trouvé! C'est k = " + k + " et n = " + n);
        System.exit(1);
    }
}
