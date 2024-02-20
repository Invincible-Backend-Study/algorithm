import java.util.*;

class Solution {
    Map<String, Integer> personCount = new HashMap<>();
    
    public String solution(String[] participant, String[] completion) {
        
        for (String name : participant) {
            personCount.put(name, personCount.getOrDefault(name, 0) + 1);
        }
        for (String name : completion) {
            personCount.put(name, personCount.get(name) - 1);
        }
        
        String answer = null;
        for (Map.Entry<String, Integer> entry : personCount.entrySet()) {
            if (entry.getValue() > 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}
