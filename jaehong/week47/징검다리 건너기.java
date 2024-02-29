import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE; 
        
        // 슬라이딩 윈도우로 푸는거 아닌가? 
        
        var ll = 0; 
        var rl = k; 
        
        var n = stones.length;
        var queue = new ArrayDeque<int[]>();
        
        for(int i = 0; i < n;i++){
            var num = stones[i];
            while(!queue.isEmpty() && queue.getFirst()[0] < num) queue.removeFirst();
            queue.push(new int[] {num, i});
            
            if(queue.getLast()[1] <= i - k) queue.removeLast();
            if(i >= k - 1) answer = Math.min(answer, queue.getLast()[0]);
        }
        return answer;
    }
}
