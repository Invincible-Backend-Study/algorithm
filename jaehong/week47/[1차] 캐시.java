import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        var deque = new ArrayDeque<String>();
        
        int answer = 0;
        
        for(var city: cities){
            city = city.toLowerCase();
             if(deque.contains(city)){
                answer += 1;
                deque.remove(city); 
                deque.offerFirst(city);
            }else{
                answer += 5; 
                
                if(!deque.isEmpty() && deque.size() == cacheSize) {
                    deque.pollLast();
                }
                if(cacheSize != 0) deque.offerFirst(city);
            }
        }
        return answer;
    }
}

// 캐시 처리를 0
