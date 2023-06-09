// DP
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
       
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0) {
                dp[0][i] = dp[0][i - 1] + 1;
            }
            for (int j = 1; j <= k; j++) {
                if (num % 2 == 0) {
                    dp[j][i] = dp[j][i - 1] + 1;
                } else {
                    dp[j][i] = dp[j - 1][i - 1];
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[k][i], max);
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}

// 투 포인터
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int l = 0, r = 0;
        int count = 0;
        int max = 0;
        while (r < n) {
            if (count <= k) {
                count += arr[r++] % 2;
            } else {
                count -= arr[l++] % 2;
            }
            if (count <= k) {
                max = Math.max(max, r - l - count);
            }
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
