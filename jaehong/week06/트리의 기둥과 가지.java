import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj20924 {
    public static void main(String... args) throws Exception {
        // N 노드의 개수, R루트 노드 번호

        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        var N = Integer.parseInt(st.nextToken());
        var R = Integer.parseInt(st.nextToken());

        var tree = new ArrayList<ArrayList<Node>>();
        var distance = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<Node>());
        }

        var inputCase = N;

        while (inputCase-- > 1) {
            //a노드와 b 노드가 연결되어있으며 간선의 길이는 e다

            st = new StringTokenizer(br.readLine());
            var a = Integer.parseInt(st.nextToken());
            var b = Integer.parseInt(st.nextToken());
            var d = Integer.parseInt(st.nextToken());

            tree.get(a).add(new Node(b, d));
            tree.get(b).add(new Node(a, d));
        }

        var now = R;
        var bodyLength = 0;
        var visited = new boolean[N + 1];

        visited[R] = true;

        while (true) {
            var nodes = tree.get(now);
            // 자식노드가 2개인 경우 그리고 리프노드 인경우
            //
            var gigaNodeExists = nodes.size() > 2 || (now == R && nodes.size() == 2);
            var gigaNodeNotExists = (now != R && nodes.size() == 1) || (now == R && nodes.size() == 0);

            if (gigaNodeExists || gigaNodeNotExists) {
                break;
            }
            for (var node : nodes) {
                if (!visited[node.number]) {
                    visited[node.number] = true;
                    now = node.number;
                    bodyLength += node.distance;
                }
            }
        }

        var maxLeafLength = dfs(tree, visited, now);
        System.out.printf("%d %d%n", bodyLength, maxLeafLength);
    }

    static int dfs(ArrayList<ArrayList<Node>> tree, boolean[] visited, int level) {
        var nodes = tree.get(level);

        if (nodes.size() == 1) {
            return 0;
        }

        var max = 0;
        for (var node : nodes) {
            if (!visited[node.number]) {
                visited[node.number] = true;
                max = Math.max(max, dfs(tree, visited, node.number) + node.distance);
            }
        }
        return max;
    }
}

class Node {
    int number;
    int distance;

    Node(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("number %d, distance %d", number, distance);
    }
}
