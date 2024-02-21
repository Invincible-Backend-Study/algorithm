import java.util.*;

class Solution {
    
    int n;
    
    public Integer[] solution(int[] progresses, int[] speeds) {
        this.n = progresses.length;
        List<Integer> leftDays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int leftProgress = 100 - progresses[i];
            if (leftProgress % speeds[i] == 0) {
                leftDays.add(leftProgress / speeds[i]);
            } else {
                leftDays.add(leftProgress / speeds[i] + 1);
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        int preMaxDay = leftDays.get(0);
        int count = 0;
        for (int day : leftDays) {
            if (day <= preMaxDay) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                preMaxDay = day;
            }
        }
        answer.add(count);
        
        return answer.toArray(new Integer[0]);
    }
}
