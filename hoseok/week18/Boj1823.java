
// bottomUp 풀이
/*
    2 2 1 2 -> 8, 8, 4, 8 (dp[1][1], dp[2][2], dp[3][3], dp[4][4])
    22 21 12 -> 14, 11, 11 (dp[1][2], dp[2][3], dp[3][4])
    221 212 -> 16, 14 (dp[1][3], dp[2][4])
    2212 -> 18 (dp[1][4])
    dp[i][j] -> i ~ j까지의 범위를 이용해 수확을 할 경우 얻을 수 있는 최대의 이익

*/
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            dp[i][i] = numbers[i] * n;
        }

        for (int gap = 1; gap <= n; gap++) {
            for (int i = 1; gap + i <= n; i++) {
                int j = i + gap;
                dp[i][j] = Math.max(dp[i][j - 1] + (n - gap) * numbers[j] , dp[i + 1][j] + (n - gap) * numbers[i]);
            }
        }

        bw.write(dp[1][n] + "");
        bw.flush();
        bw.close();
    }
}

// topDown 풀이
import java.io.*;

class Main {
    private static int[] numbers;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            dp[i][i] = numbers[i] * n;
        }

        int result = recur(1, n, 1);

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    public static int recur(int start, int end, int num) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        dp[start][end] = Math.max(recur(start + 1, end, num + 1) + numbers[start] * num, recur(start, end - 1, num + 1) + numbers[end] * num);
        return dp[start][end];
    }
}
