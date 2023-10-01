import java.io.*;
import java.util.*;

class Main {

    private static final int[] rows = {-1, 0, 1, 0, 0, 0};
    private static final int[] cols = {0, 1, 0, -1, 0, 0};
    private static final int[] heights = {0, 0, 0, 0, 1, -1};

    static class Node {
        int h, r, c;

        Node(int h, int r, int c) {
            this.h = h;
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
        int h = Integer.parseInt(st.nextToken());

        int[][][] map = new int[h][n][m];
        Queue<Node> que = new LinkedList<>();
        int emptyCount = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        que.offer(new Node(i, j, k));
                    } else if (map[i][j][k] == 0) {
                        emptyCount++;
                    }
                }
            }
        }

        int finalDayCount = 1;
        while (!que.isEmpty()) {
            Node curNode = que.poll();

            for (int i = 0; i < 6; i++) {
                int nextH = curNode.h + heights[i];
                int nextR = curNode.r + rows[i];
                int nextC = curNode.c + cols[i];

                if (nextH < 0 || nextH >= h
                    || nextR < 0 || nextR >= n
                    || nextC < 0 || nextC >= m) {
                    continue;
                }

                if (map[nextH][nextR][nextC] == 0) {
                    emptyCount--;
                    map[nextH][nextR][nextC] = map[curNode.h][curNode.r][curNode.c] + 1;
                    finalDayCount = Math.max(finalDayCount, map[nextH][nextR][nextC]);
                    que.offer(new Node(nextH, nextR, nextC));
                }
            }
        }

        if (emptyCount > 0) {
            bw.write("-1");
        } else {
            bw.write((finalDayCount - 1) + "");
        }
        bw.flush();
        bw.close();
    }
}
