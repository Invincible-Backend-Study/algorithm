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

    private static int[][] map;
    private static int n, m;
    private static List<Node> emptyNode = new ArrayList<>();
    private static List<Node> viruses = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptyNode.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    viruses.add(new Node(i, j));
                }
            }
        }

        int maxSafeArea = 0;
        for (int i = 0; i < emptyNode.size(); i++) {
            for (int j = i + 1; j < emptyNode.size(); j++) {
                for (int k = j + 1; k < emptyNode.size(); k++) {
                    int count = 0;
                    setWall(i, j, k, 1);
                    boolean[][] check = new boolean[n][m];
                    for (Node node : viruses) {
                        count += bfs(node, check);
                    }
                    setWall(i, j, k, 0);
                    maxSafeArea = Math.max(emptyNode.size() - count - 3, maxSafeArea);
                }
            }
        }

        bw.write(maxSafeArea + "");
        bw.flush();
        bw.close();
    }

    public static int bfs(Node startNode, boolean[][] check) {
        int count = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(startNode);
        check[startNode.r][startNode.c] = true;

        while (!que.isEmpty()) {
            Node curNode = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = curNode.r + rows[i];
                int nextC = curNode.c + cols[i];

                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
                    continue;
                }
                if (map[nextR][nextC] == 0 && !check[nextR][nextC]) {
                    count++;
                    check[nextR][nextC] = true;
                    que.offer(new Node(nextR, nextC));
                }
            }
        }

        return count;
    }

    public static void setWall(int i, int j, int k, int value) {
        map[emptyNode.get(i).r][emptyNode.get(i).c] = value;
        map[emptyNode.get(j).r][emptyNode.get(j).c] = value;
        map[emptyNode.get(k).r][emptyNode.get(k).c] = value;
    }
}
