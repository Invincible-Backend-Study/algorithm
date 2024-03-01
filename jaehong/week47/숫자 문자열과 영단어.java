import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, Integer> table = new HashMap<>(){{
            this.put("zero",0);
            this.put("one",1);
            this.put("two",2);
            this.put("three",3);
            this.put("four", 4);
            this.put("five", 5);
            this.put("six",6);
            this.put("seven",7);
            this.put("eight",8); 
            this.put("nine",9);
        }};
        
        for(var e: table.entrySet()) s = s.replace(e.getKey(), String.valueOf(e.getValue()));
        
        
        return Integer.parseInt(s);
    }
}
