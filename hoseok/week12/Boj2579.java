import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = stairs[1];
        if (n >= 2) {
            dp[2] = stairs[2] + dp[1];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(stairs[i - 1] + dp[i - 3], dp[i - 2]) + stairs[i];
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}


