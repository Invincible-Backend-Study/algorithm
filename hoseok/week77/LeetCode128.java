import java.util.*;

class Solution {

    Set<Integer> numbers = new HashSet<>();

    public int longestConsecutive(int[] nums) {
        for (int num : nums) {
            numbers.add(num);
        }

        int count = 0;
        for (int num : nums) {
            if (numbers.contains(num - 1)) {
                continue;
            }
            int length = 1;

            while (numbers.contains(num + length)) {
                length++;
            }
            count = Math.max(length, count);
        }

        return count;
    }
}
