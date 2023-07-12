import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] stones = new int[n][2];
        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stones[i][0] = Integer.parseInt(st.nextToken());
            stones[i][1] = Integer.parseInt(st.nextToken());
        }
        int biggestJump = Integer.parseInt(br.readLine());

        dp[0] = 1000000000;
        dp[1] = 0;
        if (n >= 2) {
            dp[2] = stones[1][0];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + stones[i - 1][0], dp[i - 2] + stones[i - 2][1]);
        }

        int min = dp[n];
        for (int i = 1; i + 3 <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp2[j] = dp[j];
            }
            if (dp2[i] + biggestJump < dp2[i + 3]) {
                dp2[i + 3] = dp2[i] + biggestJump;
                for (int j = i + 4; j <= n; j++) {
                    dp2[j] = Math.min(dp2[j - 1] + stones[j - 1][0], dp2[j - 2] + stones[j - 2][1]);
                }
            }
            min = Math.min(dp2[n], min);
        }

        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}
