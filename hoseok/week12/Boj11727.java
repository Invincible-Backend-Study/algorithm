import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % 10_007 + dp[i - 2] * 2 % 10_007;
        }
        
        bw.write((dp[n] % 10_007) + "");
        bw.flush();
        bw.close();
    }
}
