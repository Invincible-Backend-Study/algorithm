import java.util.*;

class Solution {
    
    int[] parents;
    int answer;
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        int count = 0;
        for (int[] cost : costs) {
            // 합집합이 됐다면 해당 간선을 더해주어야 함
            if (union(cost[0], cost[1])) {
                answer += cost[2];    
            }
        }
        return answer;
    }
    
    public boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) {
            return false;
        }
        if (a > b) {
            parents[a] = b;
        } else {
            parents[b] = a;
        }
        return true;
    }
    
    public int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}
