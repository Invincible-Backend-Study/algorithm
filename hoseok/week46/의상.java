import java.util.*;

class Solution {
    
    Map<String, Integer> clothCount = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        for (String[] cloth : clothes) {
            clothCount.put(cloth[1], clothCount.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (String key : clothCount.keySet()) {
            answer = answer * (clothCount.get(key) + 1);
        }
        return answer - 1;
    }
    
}
