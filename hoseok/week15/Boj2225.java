import java.io.*;
import java.util.*;

class Main {
    private static final int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k + 1][n + 1];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= k; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] % INF + dp[i][j - 1] % INF;
            }
        }

        bw.write((dp[k][n] % INF) + "");
        bw.flush();
        bw.close();
    }
}
