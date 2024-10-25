import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int sameCount = 1;
        int number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (number == nums[i]) {
                sameCount++;
            } else {
                number = nums[i];
                sameCount = 1;
            }
            if (sameCount > 2) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        Arrays.sort(nums);

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                k++;
            } else {
                break;
            }
        }

        return k;
    }
}
