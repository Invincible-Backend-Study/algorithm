/*
     아무점이나 시작해서 가장 먼 점을 구한다.

     이후 해당 점에서 다시 가장 먼점을 구하면 트리의 지름을 구할 수 있다.
 */
import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int number, weight;
        Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }

    private static List<Node>[] trees;
    private static boolean[] visited;
    private static int selectNodeNumber = 1;
    private static int weightSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        trees = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            trees[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            trees[start].add(new Node(end, weight));
            trees[end].add(new Node(start, weight));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        doDfs(1, 0);

        weightSum = 0;
        visited = new boolean[n + 1];
        visited[selectNodeNumber] = true;
        doDfs(selectNodeNumber, 0);

        bw.write(weightSum + "");
        bw.flush();
        bw.close();
    }

    public static void doDfs(int nodeNumber, int sum) {
        if (trees[nodeNumber].size() == 1 && nodeNumber != selectNodeNumber) {
            if (weightSum < sum) {
                weightSum = sum;
                selectNodeNumber = nodeNumber;
            }
            return;
        }
        for (Node node : trees[nodeNumber]) {
            if (!visited[node.number]) {
                visited[node.number] = true;
                doDfs(node.number, sum + node.weight);
            }
        }
    }
}
