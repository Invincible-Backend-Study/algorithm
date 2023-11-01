import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 6];
        int[][] counselings = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            counselings[i][0] = Integer.parseInt(st.nextToken());
            counselings[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(dp[i], max);
            dp[i + counselings[i][0]] = Math.max(max + counselings[i][1], dp[i + counselings[i][0]]);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
