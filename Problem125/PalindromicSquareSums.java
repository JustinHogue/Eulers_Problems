import java.lang.Math;
import java.util.*;
import java.util.stream.*;

public class PalindromicSquareSums {
    private static final int LIMIT = (int) Math.pow(10, 8);
    public static boolean isPalindromic(long number) {
        String numberToString = String.valueOf(number);
        String inversedNumberString = new StringBuilder(numberToString).reverse().toString();
        long inversedNumber = Long.parseLong(inversedNumberString);
        return inversedNumber == number;
    }
    public static void main(String[] args) {
        List<Long> totalSum = new ArrayList<Long>();
        int[] arr = IntStream.range(1, 7072).toArray();
        for (int i = 0; i < arr.length; i++) {
            long sum = arr[i] * arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j] * arr[j];
                if (sum < LIMIT && isPalindromic(sum) && !totalSum.contains(sum)) {
                    totalSum.add(sum);
                } else if (LIMIT <= sum) {
                    break;
                }
            }
        }
        long finalSum = totalSum.stream().mapToLong(a -> a).sum();
        System.out.println(finalSum);
    }
}
