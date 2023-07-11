import java.util.*;
import java.io.*;
public class Boj11660{
    public static void main(String... args) throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        var sb = new StringBuilder();
        var n = Integer.parseInt(st.nextToken());
        var m = Integer.parseInt(st.nextToken());
        var dp= new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 1; k <= m; k++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            var x1 = Integer.parseInt(st.nextToken());
            var y1 = Integer.parseInt(st.nextToken());
            var x2 = Integer.parseInt(st.nextToken());
            var y2 = Integer.parseInt(st.nextToken());
            for(int i = x1; i <= x2; i++) {
                sum = sum + (dp[i][y2] - dp[i][y1-1]);
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}
