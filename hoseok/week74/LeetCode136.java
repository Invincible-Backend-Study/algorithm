class Solution {
    public int singleNumber(int[] nums) {
        
        int answer = nums[0];

        for (int i = 1 ; i < nums.length; i++) {
            answer ^= nums[i];
        }

        return answer;
    }
}
