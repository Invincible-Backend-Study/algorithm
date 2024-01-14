import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int x, y, count;

        public Node (int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int n, t, maxX;
    static List<Integer>[] pos;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        pos = new ArrayList[t + 1];

        for (int i = 0; i <= t; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            maxX = Math.max(x, maxX);
            int y = Integer.parseInt(st.nextToken());
            pos[y].add(x);
        }

        for (int i = 0; i <= t; i++) {
            pos[i].sort(Comparator.naturalOrder());
        }

        bw.write(bfs() + "");
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0, 0));
        boolean[][] visited = new boolean[maxX + 1][t + 1];

        while (!que.isEmpty()) {
            Node curNode = que.poll();
            if (curNode.y == t) {
                return curNode.count;
            }
            for (int i = -2; i <= 2; i++) {
                int nextY = curNode.y + i;
                if (nextY > t || nextY < 0) {
                    continue;
                }
                for (int nextX : pos[nextY]) {
                    if (Math.abs(curNode.x - nextX) <= 2 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        que.offer(new Node(nextX, nextY, curNode.count + 1));
                    }
                }
            }
        }
        return -1;
    }
}
