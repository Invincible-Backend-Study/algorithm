import java.io.*;
import java.util.*;

class Main {
    private static final int OFFSET = 1111111111;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, OFFSET);
        
        dp[3] = 1;
        if (n >= 5) {
            dp[5] = 1;
        }
        
        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]);
            if (dp[i] != OFFSET) {
                dp[i]++;
            }
        }
        
        if (dp[n] == OFFSET) {
            bw.write("-1");
        } else {
            bw.write(dp[n] + "");
        }
        bw.flush();
        bw.close();
    }
}
