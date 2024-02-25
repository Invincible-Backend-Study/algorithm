import java.io.*;
import java.util.*;

class Main {

    static int n;
    static List<Integer>[] graph;
    static int from, to;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (edge-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> que = new LinkedList<>();
        que.offer(from);
        visited[from] = 0;
        while (!que.isEmpty()) {
            int current = que.poll();

            if (current == to) {
                break;
            }
            for (int next : graph[current]) {
                if (visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    que.offer(next);
                }
            }
        }

        bw.write(Integer.toString(visited[to]));
        bw.flush();
        bw.close();
    }
}
