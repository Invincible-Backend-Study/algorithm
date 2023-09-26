import java.io.*;
import java.util.*;

class Main {

    private static final int[] rows = {-1, 0, 1, 0};
    private static final int[] cols = {0, 1, 0, -1};

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Pos> que = new LinkedList<>();
        que.offer(new Pos(0, 0));
        distance[0][0] = 1;

        while (!que.isEmpty()) {
            Pos curPos = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = curPos.r + rows[i];
                int nextC = curPos.c + cols[i];

                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
                    continue;
                }
                if (map[nextR][nextC] == 1 && distance[nextR][nextC] == 0) {
                    distance[nextR][nextC] = distance[curPos.r][curPos.c] + 1;
                    que.offer(new Pos(nextR, nextC));
                }
            }
        }

        bw.write(distance[n - 1][m - 1] + "");
        bw.flush();
        bw.close();
    }
}
