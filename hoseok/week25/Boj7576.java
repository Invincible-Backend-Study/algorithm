import java.io.*;
import java.util.*;

class Main {

    private static final int[] rows = {-1, 0, 1, 0};
    private static final int[] cols = {0, 1, 0, -1};

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    que.offer(new Node(i, j));
                }
            }
        }

        int finalDay = 0;
        while (!que.isEmpty()) {
            Node curNode = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = rows[i] + curNode.r;
                int nextC = cols[i] + curNode.c;

                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || map[nextR][nextC] == -1) {
                    continue;
                }
                if (map[nextR][nextC] == 0) {
                    map[nextR][nextC] = map[curNode.r][curNode.c] + 1;
                    finalDay = Math.max(finalDay, map[nextR][nextC] - 1);
                    que.offer(new Node(nextR, nextC));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    bw.write("-1");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }

        bw.write(finalDay + "");
        bw.flush();
        bw.close();
    }
}
