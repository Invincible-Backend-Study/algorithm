// BFS
import java.io.*;
import java.util.*;

class Main {
    private static List<Integer>[] graphs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        graphs = new ArrayList[n + 1];
        int edge = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        while (edge-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graphs[s].add(e);
            graphs[e].add(s);
        }

        boolean[] visited = new boolean[n + 1];
        int count = 0;
        Queue<Integer> que = new LinkedList<>();
        visited[1] = true;
        que.add(1);
        while (!que.isEmpty()) {
            int curNode = que.poll();

            for (int nextNode : graphs[curNode]) {
                if (!visited[nextNode]) {
                    count++;
                    visited[nextNode] = true;
                    que.offer(nextNode);
                }
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}

// DFS
import java.io.*;
import java.util.*;

class Main {
    private static List<Integer>[] graphs;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        graphs = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        int edge = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        while (edge-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graphs[s].add(e);
            graphs[e].add(s);
        }
        visited[1] = true;
        dfs(1);

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
    
    public static void dfs(int node) {        
        for (int nextNode : graphs[node]) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                count++;
                dfs(nextNode);
            }
        }
    }
}
