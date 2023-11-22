import java.io.*;
import java.util.*;

class Main {

    private static final int[] rows = {-1, 0, 1, 0};
    private static final int[] cols = {0, 1, 0, -1};

    private static int N, L, R, count;
    private static int[][] map;
    private static int[][] visited;
    private static List<Node> openBorderNodes = new ArrayList<>();

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

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == count) {
                        isMoved |= bfs(new Node(i, j));
                    }
                }
            }
            if (!isMoved) {
                break;
            }
            count++;

        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    public static boolean bfs(Node startNode) {
        Queue<Node> que = new LinkedList<>();

        que.offer(startNode);
        openBorderNodes.add(startNode);
        visited[startNode.r][startNode.c] = count + 1;
        int sum = map[startNode.r][startNode.c];

        while (!que.isEmpty()) {
            Node curNode = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = curNode.r + rows[i];
                int nextC = curNode.c + cols[i];

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) {
                    continue;
                }

                if (visited[nextR][nextC] != count + 1 && canOpenBorder(curNode, nextR, nextC)) {
                    visited[nextR][nextC] = count + 1;
                    sum += map[nextR][nextC];
                    Node nextNode = new Node(nextR, nextC);
                    que.offer(nextNode);
                    openBorderNodes.add(nextNode);
                }
            }
        }
        int avg = sum / openBorderNodes.size();
        for (Node node : openBorderNodes) {
            map[node.r][node.c] = avg;
        }

        if (openBorderNodes.size() > 1) {
            openBorderNodes.clear();
            return true;
        }
        openBorderNodes.clear();
        visited[startNode.r][startNode.c] = count;
        return false;
    }

    public static boolean canOpenBorder(Node node, int r, int c) {
        int difference = Math.abs(map[node.r][node.c] - map[r][c]);
        return difference >= L && difference <= R;
    }
}
