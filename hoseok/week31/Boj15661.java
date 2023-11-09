import java.io.*;
import java.util.*;

class Main {

    static int n, total;
    static int[][] scores;
    static int[] eachScoreSum;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        scores = new int[n][n];
        eachScoreSum = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
                total += scores[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += scores[i][j] + scores[j][i];
            }
            eachScoreSum[i] = sum;
        }

        combinations(0, n);

        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    public static void combinations(int index, int r) {
        if (r >= 0) {
            updateMinDifference();
        }
        for (int i = index; i < n; i++) {
            visited[i] = true;
            combinations(i + 1, r - 1);
            visited[i] = false;
        }
    }

    public static void updateMinDifference() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += eachScoreSum[i];
            }
        }
        min = Math.min(min, Math.abs(total - sum));
    }
}
