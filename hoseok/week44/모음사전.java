import java.util.*;

class Solution {
    
    final List<String> allPermutations = new ArrayList<>();
    final String[] targets = {"A", "E", "I", "O", "U"};
    int answer;
    int totalCount;
    
    public int solution(String word) {
        
        dupPermutations(5, 0, "", word);
                
        return answer;
    }
    
    public void dupPermutations(int size, int index, String out, String word) {
        if (out.equals(word)) {
            answer = totalCount;
            return;
        }
        
        if (index == size) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            totalCount++;
            dupPermutations(size, index + 1, out + targets[i], word);
        }
    }
}
