/*
    조합의 2가지 공식을 사용합니다.
    1. nCn == nC0 == 1;
    2. nCr = n-1Cr-1 + n-1Cr

    또한 계산되는 값이 long타입을 벗어나므로 BigInteger 클래스를 이용합니다.
*/

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        BigInteger[][] dp = new BigInteger[101][101];

        for (int i = 0; i <= 100; i++) {
            dp[i][i] = new BigInteger("1");
            dp[i][0] = new BigInteger("1");
        }

        for (int i = 1; i <= r; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[j][i] = dp[j - 1][i - 1].add(dp[j - 1][i]);
            }
        }

        bw.write(dp[n][r].toString());
        bw.flush();
        bw.close();
    }
}

