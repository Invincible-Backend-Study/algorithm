import java.util.*;

class Solution {
    public int solution(String s) {
        var answer = 0;
        var maxCount = s.length();
        
        var queue = new ArrayDeque<Character>();
        
        for(var c: s.toCharArray()) queue.offerLast(c);
        
        while(maxCount-- > 0){
            var store = new ArrayDeque<Character>();
            var sub = new ArrayDeque<Character>();
            var flag = true;
            while(!queue.isEmpty()){
                var e = queue.pollFirst();
                store.offerLast(e);
                
                if(e == '(' || e == '{' || e == '[') sub.offerLast(e);
                else if(sub.size() == 0) {
                    flag = false;
                    break;
                }
                else{ 
                    var pl = sub.pollLast();
                    
                    if(e == ')' && pl == '(') continue;
                    if(e == '}' && pl == '{') continue;
                    if(e == ']' && pl == '[') continue; 
                    
                    flag = false;
                    break;
                }
            }
            
            if(sub.isEmpty() && flag) answer++;
            
            while(store.size() > 1) queue.offerFirst(store.pollLast());
            queue.offerLast(store.pollFirst());
           
            
        }
       
        return answer;
    }
}

/*


*/
