import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int next, value;

        Node(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    private static List<Node>[] trees;
    private static boolean[] visited;
    private static int n;
    private static int maxSum, maxNode;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        trees = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            trees[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            trees[start].add(new Node(end, value));
            trees[end].add(new Node(start, value));
        }

        visited[1] = true;
        dfs(1, 0);
        visited = new boolean[n + 1];

        maxSum = 0;
        visited[maxNode] = true;
        dfs(maxNode, 0);

        bw.write(maxSum + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int node, int sum) {
        if (maxSum < sum) {
            maxSum = sum;
            maxNode = node;
        }
        for (Node nextNode : trees[node]) {
            if (!visited[nextNode.next]) {
                visited[nextNode.next] = true;
                dfs(nextNode.next, sum + nextNode.value);
            }
        }
    }
}
