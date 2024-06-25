import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[] inDegree;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inDegree = new int[n];
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            inDegree[b]++;
            graph[a].add(b);
        }

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int current = que.poll();
            answer.append((current + 1)).append(" ");

            for (int next : graph[current]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}
