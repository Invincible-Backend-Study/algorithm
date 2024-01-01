import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        return findDeletePrivacies(
            convertDays(today),
            createTermsTable(terms),
            privacies
        );
        
    }
    
    public int[] findDeletePrivacies(int day, Map<String,Integer> termTable, String[] privacies){
        var list = new ArrayList<Integer>();
        
        for(int i = 0; i < privacies.length; i++){
            var privacy = privacies[i];
            var splitstr = privacy.split(" ");
            var invalidDay = convertDays(splitstr[0]) + termTable.get(splitstr[1]); 
            
            //System.out.println(invalidDay + " " + day);
            if(invalidDay <= day) list.add(i+1);
        }
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    public Map<String, Integer> createTermsTable(String[] terms){
        var table = new HashMap<String, Integer>();
        for(var term: terms){
            var splitstr = term.split(" ");
            table.put(splitstr[0], Integer.parseInt(splitstr[1]) * 31);
        }
        return table;
    }
    public int convertDays(String text) {
        var splitstr = text.split("\\.");
        
        return calculateDay(
            Integer.parseInt(splitstr[0]),
            Integer.parseInt(splitstr[1]),
            Integer.parseInt(splitstr[2])
        );
    }
    
    private int calculateDay(int year, int month, int day){
        return (((year * 12) + month )* 31) + day;
    }
}
