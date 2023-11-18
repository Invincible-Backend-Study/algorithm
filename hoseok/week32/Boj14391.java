import java.io.*;
import java.util.*;

class Main {

    private static int n, m, max = 0;
    private static int[][] map;
    private static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        dfs(0, 0);

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int r, int c) {
        if (r == n) {
            updateMax();
            return;
        } else if (c == m) {
            dfs(r + 1, 0);
            return;
        }

        visited[r][c] = true;
        dfs(r, c + 1);
        visited[r][c] = false;
        dfs(r, c + 1);
    }

    public static void updateMax() {
        // 가로 구하기
        int currentMax = 0;
        for (int i = 0; i < n; i++) {
            int number = 0;
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    number *= 10;
                    number += map[i][j];
                } else {
                    currentMax += number;
                    number = 0;
                }
            }
            currentMax += number;
        }

        // 세로 구하기
        for (int i = 0; i < m; i++) {
            int number = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j][i]) {
                    number *= 10;
                    number += map[j][i];
                } else {
                    currentMax += number;
                    number = 0;
                }
            }
            currentMax += number;
        }
        max = Math.max(currentMax, max);
    }
}
