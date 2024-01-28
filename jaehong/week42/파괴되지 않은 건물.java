import java.util.*;


class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        var N = board.length + 1;
        var M = board[0].length + 1;
        
        var acc = new int[N][M];
        
        for(var item: skill){
            var type = item[0];
            var r1 = item[1];
            var c1 = item[2];
            var r2 = item[3];
            var c2 = item[4];
            var degree = item[5] * (type == 1 ? -1 : 1);
            
            
            var accR = Math.abs(r1 - r2) + 1; 
            var accC = Math.abs(c1 - c2) + 1;
            
            
            
            acc[r1][c1] += degree;
            acc[r1 + accR][c1 + accC] += degree;
            
            acc[r1][c1 + accC] += degree * -1;
            acc[r1 + accR][c1] += degree * -1;
            
        }
        
        for(int i = 0; i < N - 1; i++){
            for(int j = 1; j < M - 1; j++){
                acc[i][j] += acc[i][j -1]; // 왼쪽에서 오른쪽으로 누적 
            }
        }
        
        for(int i = 1; i < N - 1; i++){
            for(int j = 0; j < M - 1; j ++){
                acc[i][j] += acc[i-1][j]; // 위에서 아래로 누적
            }
        }
        
        var count = 0; 
        
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 1; j++){ 
                count += board[i][j] + acc[i][j] > 0 ? 1 : 0;
            }
        }
        return count;
    }
}

/*

누적합을 이용해서 푸는 문제라고 함

1,1 3,3

*/
