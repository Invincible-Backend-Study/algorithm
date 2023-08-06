import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[][] dp = new boolean[n + 1][40501];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 40000; j++) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][Math.abs(j - weights[i])];
                dp[i][j] = dp[i][j] || dp[i - 1][j + weights[i]];
            }
        }

        StringBuilder result = new StringBuilder();
        int m = Intege.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int marble = Integer.parseInt(st.nextToken());
            if (dp[n][marble]) {
                result.append("Y ");
            } else {
                result.append("N ");
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
