import java.io.*;
import java.util.*;

class Main {

    private static final int[] rows = {-1, 0, 1, 0};
    private static final int[] cols = {0, 1, 0, -1};

    private static int n;
    private static int[][] map;
    private static Shark babyShark;

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Feed implements Comparable<Feed> {
        Node node;
        int distance;

        Feed(int r, int c, int distance) {
            this.node = new Node(r, c);
            this.distance = distance;
        }

        @Override
        public int compareTo(Feed f) {
            if (distance != f.distance) {
                return distance - f.distance;
            }
            if (node.r != f.node.r) {
                return node.r - f.node.r;
            }
            return node.c - f.node.c;
        }
    }

    static class Shark {
        Node node;
        int level = 2, eatCount;

        Shark(Node node) {
            this.node = node;
        }

        public void eat(Feed feed) {
            map[feed.node.r][feed.node.c] = 9;
            map[this.node.r][this.node.c] = 0;
            eatCount++;
            if (eatCount == level) {
                level++;
                eatCount = 0;
            }
            this.node = feed.node;
        }

        public boolean canStep(int feedLevel) {
            return feedLevel == 0 || (feedLevel != 9 && feedLevel <= level);
        }

        public boolean canEat(int feedLevel) {
            return feedLevel != 0 && feedLevel != 9 && feedLevel < level;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    babyShark = new Shark(new Node(i, j));
                }
            }
        }

        int second = 0;
        while (true) {
            Feed findFeed = bfs();
            if (findFeed == null) {
                break;
            } else {
                babyShark.eat(findFeed);
                second += findFeed.distance;
            }
        }
        bw.write(second + "");
        bw.flush();
        bw.close();
    }

    public static Feed bfs() {
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Feed> pq = new PriorityQueue<>();
        Queue<Feed> que = new LinkedList<>();
        que.offer(new Feed(babyShark.node.r, babyShark.node.c, 0));
        visited[babyShark.node.r][babyShark.node.c] = true;

        while (!que.isEmpty()) {
            Feed curFeed = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = curFeed.node.r + rows[i];
                int nextC = curFeed.node.c + cols[i];

                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) {
                    continue;
                }
                if (!visited[nextR][nextC] && babyShark.canStep(map[nextR][nextC])) {
                    visited[nextR][nextC] = true;
                    que.offer(new Feed(nextR, nextC, curFeed.distance + 1));
                    if (babyShark.canEat(map[nextR][nextC])) {
                        pq.offer(new Feed(nextR, nextC, curFeed.distance + 1));
                    }
                }
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        return pq.poll();
    }
}
