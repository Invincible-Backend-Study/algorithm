import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[0] = 1;
        for (int i = 1; i <= 10; i++) {
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
            if (i - 3 >= 0) {
                dp[i] += dp[i - 3];
            }
        }
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
