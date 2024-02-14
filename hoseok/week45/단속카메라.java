import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));
        
        int preCamera = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > preCamera) {
                answer++;
                preCamera = routes[i][1];
            }
        }
        return answer;
    }
}
