import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n + 5];
        int[] dp = new int[n + 5];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }

        int currentValue = 0;
        for (int i = 0; i < n + 1; i++) {
            currentValue = Math.max(currentValue, dp[i]);
            dp[arr[0][i] + i] = Math.max(currentValue + arr[1][i], dp[arr[0][i] + i]);
        }

        bw.write(Integer.toString(dp[n]));
        bw.flush();
        bw.close();
    }
}
