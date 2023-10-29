import java.io.*;
import java.util.*;

class Main {

    private static int n, m, max;
    private static boolean[] visited;
    private static int[][] rankings;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rankings = new int[n][m];
        visited = new boolean[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                rankings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static void combination(int index, int count) {
        if (count == 3) {
            max = Math.max(findMax(), max);
            return;
        }

        for (int i = index; i < m; i++) {
            visited[i] = true;
            combination(i + 1, count + 1);
            visited[i] = false;
        }
    }

    public static int findMax() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int curMax = 0;
            for (int j = 0; j < m; j++) {
                if (visited[j]) {
                    curMax = Math.max(curMax, rankings[i][j]);
                }
            }
            sum += curMax;
        }
        return sum;
    }
}
