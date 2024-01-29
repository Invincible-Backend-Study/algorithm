import java.util.*;
class Solution {
    
    int[] record = new int[11];
    int[] finalRecord = new int[11];
    int[] info;
    int answer = 0;
    public int[] solution(int n, int[] info) {
        
        this.info = info;
        dfs(0, n, 0);
        
        if(answer <= 0) return new int[]{-1};
        return finalRecord;
    }

    int[] copy(int[] target){
        var N = target.length;
        var arr = new int[N]; 
        for(int i = 0; i < N; i++) arr[i] = target[i];
        return arr;
    }

    // n 현재 과녁 위치
    // remain 잔여 횟수
    // score 점수 차
    void dfs(int n, int remain, int score){
        
        if(n == 11){
            if(remain > 0) record[n - 1] = remain;
            if(score > answer) {
               	answer = score;
                finalRecord = copy(record); 
            }
            else if(score == answer){
                for(int i = 10; i >= 0; i--){
                    if(record[i] > finalRecord[i]){
                        finalRecord = copy(record);
                        break;
                    }
                    if(record[i] < finalRecord[i]) break;
                }
            }
            
            record[n - 1] = 0;
            return ;
        }


        // 현재 얻을 수 있는 점수
        var gain = 10 - n; 


        // 어피치가 과녁을 맞추지 못한 경우에는 라이언이 1발만 쏴도 점수를 얻을 수 있음
        // - 라이언이 과녁을 맞출 수 있지만 무시하는 경우도 있음
        if(info[n] == 0){
            dfs(n + 1, remain, score);
            
            if(remain >= 1){
            	record[n] = 1;
            	dfs(n + 1, remain - 1, score + gain);
            	record[n] = 0;
            }
            
        }

        // 어피치가 점수를 얻는 경우
        // - 어피치가 점수를 얻는 경우는 라이언이 과녁을 맞추지 않아야 함
        // - 라이언이 점수를 얻을려면 어피치 보다 1더 높은 점수를 받아야 함

        var require = info[n] + 1; 

        // 라이언의 잔여 기회가 부족한 경우 더이상 진행할 수 없음
        // - 어피치가 확정적으로 점수를 얻음
        if(require > remain) {
            dfs(n + 1, remain, score - gain);
        }else{
            // 점수를 얻을 수 있지만 라이언에게 넘길 수 있음
            dfs(n + 1, remain, score - gain);
            // 어피치보다 더 높은 점수를 얻음
            
            record[n] += require;
            dfs(n + 1, remain - require, score + gain);
            record[n] -= require;
        }
    }
}
