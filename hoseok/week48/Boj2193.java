import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[2][n + 1];
        dp[1][1] = 1L;
        for (int i = 2; i <= n; i++) {
            dp[1][i] = dp[0][i - 1];
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
        }
        bw.write(Long.toString(dp[1][n] + dp[0][n]));
        bw.flush();
        bw.close();
    }
}
