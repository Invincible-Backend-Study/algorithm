import java.io.*;
import java.util.*;

class Main {
    
    private static final int INF = 10000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        Arrays.fill(dp, INF);
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            dp[i * i] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}
