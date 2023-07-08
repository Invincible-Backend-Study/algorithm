import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1L;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    break;
                }
                if (dp[i][j] == 0) {
                    continue;
                }
                int nextMove = map[i][j];

                if (i + nextMove < n) {
                    dp[i + nextMove][j] += dp[i][j];
                }
                if (j + nextMove < n) {
                    dp[i][j + nextMove] += dp[i][j];
                }
            }
        }

        bw.write(dp[n - 1][n - 1] + "");
        bw.flush();
        bw.close();
    }
}
