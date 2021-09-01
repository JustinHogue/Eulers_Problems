import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class abc_hits {
    private static int LIMIT = 120000;
    public static HashMap<Integer, Integer> listDivisors (int number) {
        HashMap<Integer, Integer> allDividers = new HashMap<>();
        for(int i = 1; i <= number; i++) {
            if (number % i == 0) {
                allDividers.put(i, i);
            }
        }
        return allDividers;
    }
    public static boolean isGreatestCommonDivisorOne (int firstNumber, int secondNumber) {
        HashMap<Integer, Integer> divisorsOfFirstNumber = listDivisors(firstNumber);
        HashMap<Integer, Integer> divisorsOfSecondNumber = listDivisors(secondNumber);
        Stream<Entry<Integer, Integer>> commonDivisors = divisorsOfFirstNumber.entrySet().stream().filter(e -> e.getValue().equals(divisorsOfSecondNumber.get(e.getKey())));
        return commonDivisors.count() == 1 && divisorsOfFirstNumber.containsKey(1);
    }
    public static boolean isGreatestCommonDivisorOne (int firstNumber, int secondNumber, int thirdNumber) {
        return isGreatestCommonDivisorOne(firstNumber, secondNumber) &&
            isGreatestCommonDivisorOne(firstNumber, thirdNumber) && isGreatestCommonDivisorOne(secondNumber, thirdNumber);
    }
    public static Integer rad (int number) {
        HashMap<Integer, Integer> allPrimeFactors = new HashMap<>();
        int rad = 1;
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                if(!allPrimeFactors.containsKey(i)){
                    allPrimeFactors.put(i, i);
                    rad = rad * i;
                }
                number /= i;
            }
        }
        return rad;
    }
    public static void main(String[] args) {
        int sum = 0;
        for (int a = 1; a < LIMIT/2 - 1; a++) {
            for (int b = a + 1; a + b < LIMIT; b++) {
                int c = a + b;
                if(rad(a*b*c) < c && isGreatestCommonDivisorOne(a, b, c)) {
                    sum += c;
                }
            }
        } 
        System.out.println(sum);
    }
}
