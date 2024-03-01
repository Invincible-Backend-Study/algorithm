import java.util.*; 
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length]; 

        for(int i = 0; i < n; i++){
            var a1 = toFill(arr1[i],n);
            var a2 = toFill(arr2[i],n);
            
            var sb = new StringBuilder();
            for(int j = 0; j < n; j++){
               	if(a1.charAt(j) == '1' || a2.charAt(j) == '1') sb.append("#");
                else sb.append(" ");
            }
            
            answer[i] = sb.toString();
        }
        return answer;
    }
    
    String toFill(int i, int n){
        var s = Integer.toBinaryString(i);
        return "0".repeat(n - s.length()) + s;
    }
}
