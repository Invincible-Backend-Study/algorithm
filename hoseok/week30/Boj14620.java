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
    private static int n, minCost = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] visited;
    private static Node[] nodes = new Node[3];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combinations(0, 0);

        bw.write(minCost + "");
        bw.flush();
        bw.close();
    }

    public static void combinations(int indexSum, int count) {
        if (count == 3) {
            updateMinCost();
            return;
        }

        for (int i = indexSum; i < n * n; i++) {
            if (i / n == 0 || i / n == n - 1 || i % n == 0 || i % n == n - 1) {
                continue;
            }
            nodes[count] = new Node(i / n, i % n);
            combinations(i + 1, count + 1);
        }
    }

    public static void updateMinCost() {
        visited = new boolean[n][n];
        int currentCost = 0;
        for (Node node : nodes) {
            currentCost += map[node.r][node.c];
            visited[node.r][node.c] = true;

            for (int i = 0; i < 4; i++) {
                int nextR = node.r + rows[i];
                int nextC = node.c + cols[i];

                if (visited[nextR][nextC]) {
                    return;
                }
                currentCost += map[nextR][nextC];
                visited[nextR][nextC] = true;
            }
        }
        minCost = Math.min(currentCost, minCost);
    }
}
