import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static List<Integer>[] graph;
    static int id;
    static int minKevin = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        bw.write(Integer.toString(id));
        bw.flush();
        bw.close();
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        visited[start] = 0;
        que.offer(start);

        int kevin = 0;
        while (!que.isEmpty()) {
            int current = que.poll();

            for (int next : graph[current]) {
                if (visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    kevin += visited[next];
                    que.offer(next);
                }
            }
        }
        if (minKevin > kevin) {
            id = start;
            minKevin = kevin;
        }
    }
}
