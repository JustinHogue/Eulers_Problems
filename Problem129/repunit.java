import java.math.BigInteger;

public class repunit {
    public static BigInteger R (int k){
        return new BigInteger(new String(new char[k]).replace("\0", "1"));
    }
    public static int A (int n) {
        int i = 1;
        while(true){
            if (R(i).mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) {
                return i;
            }
            i++;
        }
    }
    private static double log3(double logNumber) {
        return Math.log(logNumber) / Math.log(3);
    }
    public static void main(String[] args) {
        int k = 0;
        int n = 1000005;
        while (k < 1000000){
            if (n % 5 == 0){
                n = n + 2;
                continue;
            } else if (log3(n) % 1 == 0) {
                k = n;
            } else if (log3(n/7) % 1 == 0) {
                k = 2 * n/7;
            } else if (log3(n/11) % 1 == 0) {
                k = 2 * n/11;
            } else if (log3(n/13) % 1 == 0) {
                k = 2 * n/13;
            } else if (log3(n/17) % 1 == 0) {
                k = 16 * n/17;
            } else if (log3(n/19) % 1 == 0) {
                k = 2 * n/19;
            } else if (log3(n/23) % 1 == 0) {
                k = 22 * n/23;
            } else if (log3(n/29) % 1 == 0) {
                k = 28 * n/29;
            } else if (log3(n/31) % 1 == 0) {
                k = 5 * n/31;
            } else if (log3(n/37) % 1 == 0) {
                k = n/37;
            } else if (log3(n/41) % 1 == 0) {
                k = 5 * n/41;
            } else if (log3(n/43) % 1 == 0) {
                k = 7 * n/43;
            } else if (log3(n/47) % 1 == 0) {
                k = 46 * n/47;
            } else if (log3(n/59) % 1 == 0) {
                k = 58 * n/59;
            } else if (log3(n/61) % 1 == 0) {
                k = 60 * n/61;
            } else {
                k = A(n);
            }
            System.out.println("This is n:" + n);
            System.out.println("This is k:" + k);
            n = n + 2;
        }
    }
}