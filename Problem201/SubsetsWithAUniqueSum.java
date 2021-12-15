import java.util.List;

public class SubsetsWithAUniqueSum {
    public static long add(List<Integer> subset) {
        long sum = 0;
        for(Integer currentValue : subset) {
            sum += currentValue;
        }
        return sum;
    }
    public static void main(String[] args) {

    }
}
