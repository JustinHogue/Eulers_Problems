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
    public static boolean isTheSumOfConsecutiveSquares(long number) {
        long smallestSquareAdditionner = (long) Math.sqrt(number);
        for(int i = 1; i <= smallestSquareAdditionner; i++) {
            long sum = (long) Math.pow(i, 2);
            for(int j = i + 1;  j <= smallestSquareAdditionner; j++) {
                sum += Math.pow(j, 2);
                if (sum == number) {
                    return true;
                } else if (sum > number) {
                    break;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        long sum = 0;
        for(long i = 1; i <= LIMIT; i++) {
            if(isPalindromic(i)){
                if(isTheSumOfConsecutiveSquares(i)){
                    System.out.println(i);
                    sum += i;
                }
            }
        }
        System.out.println(sum);
    }
}
