import java.util.*; 
class Solution {
    public int[] solution(String s) {
        s = s.replace("{", "").replace("}","");
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(var c: s.split(",")){
            var k = Integer.parseInt(c); 
            map.putIfAbsent(k, 0);
            map.put(k, map.get(k) + 1);
        }
        
        return map.entrySet()
            .stream()
            .sorted((e1,e2) -> e2.getValue() - e1.getValue())
            .mapToInt(e -> e.getKey()) 
            .toArray();
    }
}
