/*
    dp[i] = i일에 받을 수 있는 최대값

    우선 1 ~ N일을 순회하면서 i일 + t[i]인 dp[i + t[i]]에 p[i]를 더해주는데 현재 dp[i]에 존재하는 값이 있을 수 있으므로 해당 값도 누적하여 더해야 합니다.
    또한 dp[i + t[i]]에 이미 다른 dp값이 있을 수 있으므로 dp[i + t[i]]와 p[i] + dp[i]의 크기 비교를 하여 더 큰값을 초기화합니다.

    점화식은 다음과 같습니다. dp[i + t[i]] = Math.max(dp[i] + p[i], dp[i + t[i]]);

    몇가지 예외적인 상황일 발생할 수 있습니다.
      - i + t[i]의 값이 N + 1을 초과하면 더하지 않습니다.
        N + 1일까지 되는 이유는 N일째에 1일치 상담이 들어올 수 있기 때문입니다.
      - 최대로 나올 수 있는 비용은 1_500_000_000이므로 int 타입으로 커버가 가능합니다.
      - 마지막 일자전에 모든 상담이 끝날 수 있으므로 최대 상담 비용은 dp값이 갱신될때 같이 갱신해줍니다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 51];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            // dp값이 연속적으로 업데이트되지 않으므로 이전까지 구한 dp의 최대값을 현재 dp에 갱신합니다.
            dp[i] = Math.max(max, dp[i]);
            // 위에서 dp[i] > max인 경우 max의 값도 업데이트 해주어야 합니다.
            max = Math.max(max, dp[i]);
            // 이후 점화식을 통해 최대 비용을 계속 계산해 갑니다.
            dp[i + t[i]] = Math.max(dp[i] + p[i], dp[i + t[i]]);
        }
        // n일차에 1일치의 상담이 있다면 n + 1일에 정산금을 받으므로 해당 금액까지 고려합니다.
        bw.write(Math.max(max, dp[n + 1]) + "");
        bw.flush();
        bw.close();
    }
}
