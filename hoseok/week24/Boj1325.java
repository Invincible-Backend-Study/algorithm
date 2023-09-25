import java.io.*;
import java.util.*;

class Main {
    private static List<Integer>[] graphs;
    private static boolean[] visited;
    private static int[] visitedNodeCount;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graphs = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graphs[s].add(e);
        }

        visitedNodeCount = new int[n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            visitedNodeCount[i]++;
            dfs(i);
        }

        for (int count : visitedNodeCount) {
            max = Math.max(count, max);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (max == visitedNodeCount[i]) {
                result.append(i).append(" ");
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int node) {
        for (int nextNode : graphs[node]) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                visitedNodeCount[nextNode]++;
                dfs(nextNode);
            }
        }
    }
}
