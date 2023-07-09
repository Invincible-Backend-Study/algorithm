/*
    1. 현재 잔을 먹고, -1 위치의 잔을 먹고, -3위치의 dp값
    2. 현재 잔을 먹고, -2 위치의 dp값
    3. 현재 잔을 먹지 않고, -1위치의 dp값
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(arr[i] + arr[i - 1] + dp[i - 3], Math.max(arr[i] + dp[i - 2], dp[i - 1]));
        }
        
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}
