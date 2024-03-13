/*
    - 1 2 3
        - 1, 2, 3생존 가능
    - 1 3 2
        - 1, 2 생존 가능
    - 2 1 3
        - 1 ,2, 3 생존가능
        
    즉 가운데 있는 수가 양쪽 수보다 더 크면 가운데수는 생존하지 못함
*/
class Solution {
    
    int n;
    public int solution(int[] a) {
        if (a.length < 2) {
            return a.length;
        }
        n = a.length;
        int answer = 0;

        int[] rightMin = new int[n];
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        
        int leftMin = a[0];
        for (int i = 0; i < n; i++) {
            if (!(leftMin < a[i] && rightMin[i] < a[i])) {
                answer++;
                leftMin = Math.min(a[i], leftMin);
            }
        }
        return answer;
    }
}
