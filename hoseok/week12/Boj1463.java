import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 1;
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3]);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2]);
            }
            dp[i]++;
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}
