import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        
        var now = convertDay(today);
        var termTable = new HashMap<String, Integer>();
        for(var term: terms){
            var str = term.split(" ");
            termTable.put(str[0], Integer.parseInt(str[1]));
        }
        
        var list = new ArrayList<Integer>();
        for(int i = 0; i < privacies.length; i++){
            var privacy = privacies[i];
        
            var str = privacy.split(" ");
            var day = convertDay(str[0]);
            
            if(now < (day + termTable.get(str[1]) * 28)) continue;
            
            list.add(i  + 1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
    
    int convertDay(String day){
        var str = day.split("\\.");
        return (Integer.parseInt(str[0]) * 12 + Integer.parseInt(str[1])) * 28 + Integer.parseInt(str[2]); 
    }
}
/*

n개의 개인정보

수집된 개인정보는 유효기간 전까지만 보관 가능합니다.
- 유효기간이 지나면 파기해야 합니다

A라는 유효기간이 12달, 2021.01.05에 수집된 경우 2022.01.04까지 보관 가능함 마지막 날은 포함 안됌

모든 달은 28일까지 있다고 가정함

수집 일자를 day로 바꿈


*/
