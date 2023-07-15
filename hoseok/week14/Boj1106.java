// 특정 비용으로 얻을 수 있는 최대 인원을 구한다고 가정했을때 [행==도시번호], [열==사용할비용] [dp값==특정 도시번호까지 사용했을때, 열 비용만큼으로 얻을 수 있는 최대 인원수]
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cost = new int[n + 1];
        int[] value = new int[n + 1];

        int maxCost = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
            maxCost = Math.max(cost[i], maxCost);
        }

        int[][] dp = new int[n + 1][maxCost * c + 1];

        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxCost * c; j++) {
                if (cost[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j - cost[i]] + value[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j] >= c) {
                    minValue = Math.min(minValue, j);
                }
            }
        }

        bw.write(minValue + "");
        bw.flush();
        bw.close();
    }
}


// 특정 인원수를 채우기 위한 최소 비용을 구한다고 했을때, [행==도시번호], [열==얻고자하는 인원수] [dp값==특정 도시번호까지 사용했을때, 열 인원을 얻기 위한 최소 비용]

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cost = new int[n + 1];
        int[] people = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][c + 1];

        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (people[i] < j) {
                    dp[i][j] = Math.min(dp[i][j - people[i]] + cost[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], cost[i]);
                }
            }
        }

        bw.write(dp[n][c] + "");
        bw.flush();
        bw.close();
    }
}
