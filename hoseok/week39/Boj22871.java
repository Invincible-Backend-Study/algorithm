// 이분탐색
import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long l = 1;
        long r = 5_000_000_000L;
        while(l < r) {
            long mid = (l + r) / 2;

            boolean[] dp = new boolean[n];
            dp[0] = true;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (!dp[j]) {
                        continue;
                    }
                    if (getPower(j, i) <= mid) {
                        dp[i] = true;
                    }
                }
            }

            // 갈 수 있다면 최소값
            if (dp[n - 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        bw.write(l + "");
        bw.flush();
        bw.close();
    }

    public static long getPower(int start, int end) {
        return (end - start) * (long)(1 + Math.abs(numbers[start] - numbers[end]));
    }
}

// DP
import java.io.*;
import java.util.*;

class Main {

    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.min(dp[j], Math.max(dp[i], calc(i, j)));
            }
        }

        bw.write(dp[n - 1] + "");
        bw.flush();
        bw.close();
    }

    public static long calc(int start, int end) {
        return (end - start) * (long) (1 + Math.abs(numbers[start] - numbers[end]));
    }
}
