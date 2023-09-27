import java.io.*;
import java.util.*;

class Main {

    private static final int[] rows = {-1, 0, 1, 0};
    private static final int[] cols = {0, 1, 0, -1};

    private static int[][] map;
    private static boolean[][] visited;
    private static int count;

    static class Pos {
        int r, c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> houseCounts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(new Pos(i, j));
                    houseCounts.add(count);
                    count = 0;
                }
            }
        }
        houseCounts.sort(Comparator.naturalOrder());
        bw.write(houseCounts.size() + "\n");
        for (int i = 0; i < houseCounts.size(); i++) {
            bw.write(houseCounts.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(Pos pos) {
        visited[pos.r][pos.c] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextR = pos.r + rows[i];
            int nextC = pos.c + cols[i];

            if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map.length) {
                continue;
            }
            if (!visited[nextR][nextC] && map[nextR][nextC] == 1) {
                dfs(new Pos(nextR, nextC));
            }
        }
    }
}
