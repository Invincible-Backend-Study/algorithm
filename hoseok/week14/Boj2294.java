/*
    배낭문제로 풀어보자!
    dp[i][j]의 i번째 동전까지 썼을때 j가치를 만드는 최소의 동전 개수입니다.
    
    따라서 i는 각각의 동전, j는 가치를 의미합니다.
    동전은 누적해서 사용할 수 있으므로
    j >= coins[i]일때는 dp[i][j - coins[i]] + 1를 통해 현재 코인을 사용했고 남은 금액을 이전 dp값에서 갱신할 수 있습니다.
    하지만 바로 이전 동전까지 사용했을때 최소의 개수일 수 있으므로 dp[i - 1][j]와 비교해 더 최소값을 dp[i][j]에 업데이트 합니다.
    
    따라서 점화식은 다음과 같습니다.
    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1) (j >= coins[i])
    dp[i][j] = dp[i - 1][j] (j < coins[i])
    
    dp[i - 1][j]를 비교하기 위해 인덱스가 아닌 시퀀스를 사용해서 1부터 배열이 시작하도록 하면
    dp[0]의 값들은 전부 0으로 초기화되기 때문에 Math.min시 항상 0으로 선택됩니다. 따라서 dp[0]의 모든 열들은
    최대로나올 수 있는 코인의 개수보다 큰 수인 INF(10001)로 초기화 합니다.
    
    이후 k가치를 만들 수 없는 상황이라면 해당 값은 무조건 INF로 초기화 되어있기 때문에
    이후 dp[n][k]의 값이 INF이라면 -1을 출력하고 아니라면 해당 값을 출력합니다.
*/

import java.io.*;
import java.util.*;

class Main {
    private static final int INF = 10001;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int[][] dp = new int[n + 1][k + 1];
        Arrays.fill(dp[0], INF);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }
            }
        }
        
        if (dp[n][k] == INF) {
            bw.write("-1");
        } else {
            bw.write(dp[n][k] + "");
        }
        bw.flush();
        bw.close();
    }
}
