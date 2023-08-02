// 입력받은 숫자 배열과, 거꾸로 뒤집은 숫자배열을 비교하여 양쪽이 모두 동일한 최장 공통 부분수열을 구합니다.
// 이후 n개의 숫자에서 같은 부분만 빼면 추가해야 할 숫자를 구할 수 있습니다.
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (numbers[i] == numbers[n - (j - 1)]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        bw.write((n - dp[n][n]) + "");
        bw.flush();
        bw.close();
    }
}


// 재귀함수 이용한 0, n - 1로 시작되는 left right 인덱스를 이용합니다. left, right 숫자가 같은 숫자라면 이미 팰린드롬수이므로 스킵
// 다른 숫자라면 2개의 선택지가 존재합니다, left를 증가시키는경우 혹은 right를 감소시키는 경우
// 두 개의 숫자가 다를때 팰린드롬으로 만들기 위해서는 1을 더해주어야 합니다, 따라서 두 경우의 재귀에 모두 1씩 더해주고, 그 중에서 최소값을 현재 dp에 갱신합니다.
import java.io.*;
import java.util.*;

class Main {

    private static int[] numbers;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(recur(0, n - 1) + "");
        bw.flush();
        bw.close();
    }

    public static int recur(int left, int right) {
        if (left >= right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        if (numbers[left] == numbers[right]) {
            dp[left][right] = recur(left + 1, right - 1);
        } else {
            dp[left][right] = Math.min(recur(left + 1, right) + 1, recur(left, right - 1) + 1);
        }

        return dp[left][right];
    }
}
