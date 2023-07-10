import java.io.*;
import java.util.*;

class Main {
    private static final int OFFSET = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % OFFSET;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % OFFSET;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] % OFFSET + dp[i - 1][j + 1] % OFFSET) % OFFSET;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i] % OFFSET;
            sum %= OFFSET;
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
