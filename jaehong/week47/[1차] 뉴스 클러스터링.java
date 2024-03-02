import java.util.*; 
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        var set1 = new ArrayList<String>();
        var set2 = new ArrayList<String>();
        
        var union = new ArrayList<String>();
        var sub = new ArrayList<String>();
        
        
        for(int i = 0; i < str1.length() - 1; i++){
           	var s = str1.substring(i, i + 2); 
            if(Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) set1.add(s);
        }
        for(int i = 0; i < str2.length() - 1; i++){
           	var s = str2.substring(i, i + 2); 
            if(Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) set2.add(s);
        }
        
        
        for(var item: set2){
            if(set1.contains(item)){
                sub.add(item);
                set1.remove(item);
            }
            union.add(item);
        }
        
        for(var item: set1) union.add(item);
        
        var B = union.size();
        var A = sub.size();
        
        var j = B == 0 ? 1 : 0;
        
        if(j == 1) return 65536;
        System.out.println(union + " " + sub);
        System.out.println(A + " " + B + " " + (A / (B * 1.0) * 65536));
        
        return (int) ((A / (B * 1.0)) * 65536);
            
    }
}
