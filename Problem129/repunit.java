import java.math.BigInteger;

public class repunit extends Thread {
    public static int findSmallestK(int number){
        BigInteger bigInteger = BigInteger.valueOf(11111111);
        BigInteger numBigInteger = BigInteger.valueOf(number);
        BigInteger remainder = BigInteger.TEN;
        int k = 8;
        while(remainder.compareTo(BigInteger.ZERO) != 0){
            bigInteger = bigInteger.multiply(BigInteger.TEN).add(BigInteger.ONE);
            remainder = bigInteger.remainder(numBigInteger);
            k++;
        }
        return k;
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
                k = findSmallestK(n);
            }
        }
        System.out.println("Le thread parent l'a trouvé! C'est k = " + k + " et n = " + n);
        System.exit(1);
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
                k = findSmallestK(n);
            }
        }
        System.out.println("Le thread enfant l'a trouvé! C'est k = " + k + " et n = " + n);
        System.exit(1);
    }
}
