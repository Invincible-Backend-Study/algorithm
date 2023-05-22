import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj3584 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var testCase = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();

        while (testCase-- > 0) {
            var solution = new Solution(br);
            sb.append(solution.solve()).append("\n");
        }
        System.out.print(sb);
    }
}


class Solution {
    BufferedReader br;

    Solution(BufferedReader br) {
        this.br = br;
    }

    int solve() throws Exception {
        var size = Integer.parseInt(br.readLine());
        var tree = new ArrayList<Node>();

        for (int i = 0; i <= size; i++) {
            tree.add(new Node(i));
        }
        for (int i = 0; i < size - 1; i++) {
            var st = new StringTokenizer(br.readLine());
            var parent = Integer.parseInt(st.nextToken());
            var child = Integer.parseInt(st.nextToken());

            tree.get(child).parent = tree.get(parent);
            tree.get(parent).children.add(tree.get(child));
        }

        var st = new StringTokenizer(br.readLine());
        var A = Integer.parseInt(st.nextToken());
        var B = Integer.parseInt(st.nextToken());
        var findRoot = A;

        var visited = new boolean[size + 1];
        while (true) {
            var node = tree.get(findRoot);
            visited[findRoot] = true;
            if (node.parent == null) {
                break;
            }
            findRoot = node.parent.id;
        }

        var findParent = B;

        while (true) {
            var node = tree.get(findParent);
            if (visited[findParent]) {
                return node.id;
            }
            findParent = node.parent.id;
        }

    }
}

class Node {
    int id;
    Node parent;
    List<Node> children = new ArrayList<Node>();

    Node(int id) {
        this.id = id;
    }
}
