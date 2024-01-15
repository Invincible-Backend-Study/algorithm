import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int number, weight;

        public Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
    static int n, m;
    static List<Node>[] country;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        country = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            country[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            country[a].add(new Node(b, c));
            country[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int l = 1;
        int r = 1_000_000_001;
        while (l < r) {
            int mid = (l + r) / 2;

            if (!canMove(mid, from, to)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        bw.write((l - 1) + "");
        bw.flush();
        bw.close();
    }

    public static boolean canMove(int limit, int from, int to) {
        boolean[] visited = new boolean[n + 1];
        visited[from] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(from);

        while (!que.isEmpty()) {
            int curNumber = que.poll();

            if (curNumber == to) {
                return true;
            }
            for (Node next : country[curNumber]) {
                if (!visited[next.number] && next.weight >= limit) {
                    visited[next.number] = true;
                    que.offer(next.number);
                }
            }
        }
        return false;
    }
}
