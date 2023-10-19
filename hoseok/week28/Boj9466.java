import java.util.*;
import java.io.*;

class Main {

    private static boolean[] visited;
    private static boolean[] cycleCheck;
    private static int[] nodes;
    private static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            nodes = new int[N + 1];
            visited = new boolean[N + 1];
            cycleCheck = new boolean[N + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                nodes[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                dfs(i);
            }
            answer.append((N - count)).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int curNode) {
        if (!visited[curNode]) {
            visited[curNode] = true;
            dfs(nodes[curNode]);
        } else if (!cycleCheck[curNode]) {
            count++;
            for (int i = nodes[curNode]; i != curNode; i = nodes[i]) {
                count++;
            }
        }
        cycleCheck[curNode] = true;

    }
}
