import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1L;
        for (int i = 4; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        StringBuilder answer = new StringBuilder();
        while (t-- > 0) {
            answer.append(dp[Integer.parseInt(br.readLine())])
                    .append("\n");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}
