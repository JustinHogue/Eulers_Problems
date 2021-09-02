import java.util.*;

public class abc_hits {
    private static int LIMIT = 120000;
    private static LinkedHashMap<Integer, Integer> ALL_PRIME_NUMBERS = listOfAllPrimeNumbersInGivenRange(LIMIT);
    public static LinkedHashMap<Integer, Integer> listOfAllPrimeNumbersInGivenRange (int end) {
        LinkedHashMap<Integer, Integer> allPrimeNumbers = new LinkedHashMap<>();
        for (int i = 1 ; i <= end ; i++) {
			int count = 0;
			for (int j = 1 ; j <= i ; j++) {
				if(i % j == 0)
					count = count+1;
			}
			if(count == 2)
				allPrimeNumbers.put(i, i);
		}
        return allPrimeNumbers;
    }
    public static boolean isGreatestCommonDivisorOne (int firstNumber, int secondNumber) {
        for(int i = 2; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static Long rad (long number) {
        long rad = 1;
        for(int i: ALL_PRIME_NUMBERS.values()) {
            if (number % i == 0) {
                rad *= i;
            }
        }
        return rad;
    }
    public static void main(String[] args) {
        long sum = 0;
        for (int a = 1; a < LIMIT/2; a++) {
            int incrementB = 1;
            if (a % 2 == 0) {
                incrementB = 2;
            }
            for (int b = a + 1; a + b < LIMIT; b += incrementB) {
                int c = a + b;
                if(rad((long) a*b*c) < c && isGreatestCommonDivisorOne(a,b)) {
                    sum += c;
                }
            }
        }
        System.out.println(sum);
    }
}
