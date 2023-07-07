import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            StringTokenizer top = new StringTokenizer(br.readLine());
            StringTokenizer bottom = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                stickers[0][i] = Integer.parseInt(top.nextToken());
                stickers[1][i] = Integer.parseInt(bottom.nextToken());
            }
            
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
            }
            
            result.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
