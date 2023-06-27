import java.io.*;
import java.util.*;

class Main {
    private static final int OFFSET = 2000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        int sqrtNum = (int) Math.sqrt(50000);

        Arrays.fill(dp, OFFSET);

        for (int i = 1; i <= sqrtNum; i++) {
            dp[i * i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            int currentSqrtNum = (int) Math.sqrt(i);
            for (int j = 1; j <= currentSqrtNum; j++) {
                dp[i] = Math.min(dp[i - j * j] + dp[j * j], dp[i]);
            }
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}
