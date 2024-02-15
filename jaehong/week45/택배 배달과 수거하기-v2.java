class Solution {
    public long solution(int cap, int n, int[] A, int[] B) {
        long answer = 0; 
        int L = n - 1, R = n - 1;
        while(L >= 0 || R >= 0){
            while(L >= 0 && A[L] == 0) L--;
            while(R >= 0 && B[R] == 0) R--;
            
            var l = L; 
            var r = R;
            var sl = 0;
            var sr = 0;
            
            while(l >= 0 && sl + A[l] <= cap) sl += A[l--];
            while(r >= 0 && sr + B[r] <= cap) sr += B[r--];
            if(l >= 0) A[l] -= cap - sl; 
            if(r >= 0) B[r] -= cap - sr;
            
            answer += Math.max(L, R) + 1 << 1;
            L = l;
            R = r;
        }
        return answer;
    }
}
