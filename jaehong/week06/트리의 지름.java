import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1967 {

    static List<List<Node>> tree;
    static boolean[] visited;
    static int endpoint = 0;
    static int max = 0;

    public static void main(String... args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        tree = new ArrayList<List<Node>>();

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<Node>());
        }

        for (int i = 1; i < N; i++) {
            var st = new StringTokenizer(br.readLine());

            var parent = Integer.parseInt(st.nextToken());
            var child = Integer.parseInt(st.nextToken());
            var weight = Integer.parseInt(st.nextToken());

            tree.get(parent).add(new Node(child, weight));
            tree.get(child).add(new Node(parent, weight));
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N + 1];
        visited[endpoint] = true;
        dfs(endpoint, 0);

        System.out.println(max);
    }

    static void dfs(int node, int sum) {
        var nodes = tree.get(node);
        if (max < sum) {
            max = sum;
            endpoint = node;
        }
        for (var element : nodes) {
            if (visited[element.number]) {
                continue;
            }
            visited[element.number] = true;
            dfs(element.number, sum + element.weight);
        }
    }
}

class Node {
    int number;
    int weight;

    Node(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("number %d, weight %d", number, weight);
    }
}
