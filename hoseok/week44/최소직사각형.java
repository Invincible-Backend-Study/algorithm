class Solution {
    public int solution(int[][] sizes) {
        int secondMax = 0;
        int firstMax = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            firstMax = Math.max(Math.max(sizes[i][1], sizes[i][0]), firstMax);
            secondMax = Math.max(Math.min(sizes[i][1], sizes[i][0]), secondMax);
        }
        return firstMax * secondMax;
    }
}
