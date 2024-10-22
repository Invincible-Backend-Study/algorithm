import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {
        List<String> splits = Arrays.stream(s.split(" "))
            .map(String::trim)
            .toList();

        return splits.get(splits.size() - 1).length();
    }
}
