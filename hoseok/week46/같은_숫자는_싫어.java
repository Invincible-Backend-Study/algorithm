import java.util.*;

public class Solution {
    public Integer[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        int preNumber = -1;
        for (int number : arr) {
            if (number != preNumber) {
                answer.add(number);
                preNumber = number;
            }
        }
        return answer.toArray(new Integer[0]);
    }
}
