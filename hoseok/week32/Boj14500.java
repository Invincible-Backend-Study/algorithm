import java.io.*;
import java.util.*;

class Main {

    private static final int[] rows = {-1, 0, 1, 0};
    private static final int[] cols = {0, 1, 0, -1};

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                search(i, j, 0, map[i][j]);
                visited[i][j] = false;
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static void search(int r, int c, int count, int sum) {
        if (count == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + rows[i];
            int nextC = c + cols[i];

            if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) {
                continue;
            }

            if (!visited[nextR][nextC]) {
                if (count == 1) {
                    visited[nextR][nextC] = true;
                    search(r, c, count + 1, sum + map[nextR][nextC]);
                    visited[nextR][nextC] = false;    
                }
                visited[nextR][nextC] = true;
                search(nextR, nextC, count + 1, sum + map[nextR][nextC]);
                visited[nextR][nextC] = false;
            }
        }
    }
}
