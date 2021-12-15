import java.util.*;

public class SubsetsWithAUniqueSum {
    static int LENGTH_OF_SUBSET = 50;
    public static long addAllElementsOf(ArrayList<Integer> subset) {
        long sum = 0;
        sum = subset.parallelStream().map(currentValue -> (long) currentValue).reduce(sum, (accumulator, _item) -> accumulator + _item);
        return sum;
    }
    public static ArrayList<ArrayList<Integer>> findAllSubsets (ArrayList<Integer> list, ArrayList<ArrayList<Integer>> answer){
        if (list.size() == LENGTH_OF_SUBSET) {
            if (!answer.contains(list))
                answer.add(list);
            return answer;
        }
        if (list.size() < LENGTH_OF_SUBSET) 
            return new ArrayList<>();
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            iterator.next();
            iterator.remove();
            ArrayList<Integer> copiedList = new ArrayList<>();
            list.stream().forEach(currentValue -> {
                copiedList.add(currentValue);
            });
            System.out.println(answer.size());
            findAllSubsets(copiedList, answer);
        }
        return answer;
    }
    public static void main(String[] args) {
        long indiceInMap = 1;
        long sumOfTheSet = 0;
        HashMap<Long, Long> uniqueSums = new HashMap<>();
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        ArrayList<Integer> originalSet = new ArrayList<>(){{
            for(int i = 1; i < 101; i++){
                add(i*i);
            }
        }};
        allSubsets = findAllSubsets(originalSet, allSubsets);
        for (ArrayList<Integer> currentList : allSubsets) {
            long sumOfTheSubset = addAllElementsOf(currentList);
            if(!uniqueSums.containsValue(sumOfTheSubset)){
                uniqueSums.put(indiceInMap++, sumOfTheSubset);
                sumOfTheSet += sumOfTheSubset;
            }
        }
        System.out.println(sumOfTheSet);
    }
}
