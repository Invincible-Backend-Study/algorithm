import java.io.*;
import java.util.*;

class Main {

    private static int[][] graphs;
    private static boolean[] visited;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graphs = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graphs[s][e] = 1;
            graphs[e][s] = 1;
        }

        visited = new boolean[n + 1];
        visited[v] = true;
        result.append(v).append(" ");
        doDfs(v);

        result.append("\n");

        visited = new boolean[n + 1];
        doBfs(v);

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void doDfs(int node) {
        for (int i = 1; i < graphs.length; i++) {
            if (graphs[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                result.append(i).append(" ");
                doDfs(i);
            }
        }
    }

    public static void doBfs(int node) {
        visited[node] = true;
        result.append(node).append(" ");

        Queue<Integer> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            int curNode = que.poll();

            for (int i = 1; i < graphs.length; i++) {
                if (graphs[curNode][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    result.append(i).append(" ");
                    que.offer(i);
                }
            }
        }
    }
}
