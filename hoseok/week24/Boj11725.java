import java.io.*;
import java.util.*;

class Main {

    private static List<Integer>[] graphs;
    private static boolean[] visited;
    private static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        graphs = new ArrayList[n + 1];
        parents = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graphs[node1].add(node2);
            graphs[node2].add(node1);
        }

        visited[1] = true;
        dfs(1);

        for (int i = 2; i <= n; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int node) {
        for (int nextNode : graphs[node]) {
            if (!visited[nextNode]) {
                parents[nextNode] = node;
                visited[nextNode] = true;
                dfs(nextNode);
            }
        }
    }
}
