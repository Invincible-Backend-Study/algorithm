import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj9934 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var size = Integer.parseInt(br.readLine());

        var queue = new ArrayDeque<Integer>();
        var st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        var root = create(queue, 0, queue.size() - 1);

        System.out.print(bfs(root));
    }

    static Node create(ArrayDeque<Integer> queue, int start, int end) {
        if (end - start == 2) {
            var left = queue.poll();
            var mid = queue.poll();
            var right = queue.poll();

            var node = new Node(mid);
            node.left = new Node(left);
            node.right = new Node(right);
            return node;
        }
        var half = (start + end) / 2;
        var left = create(queue, start, half - 1);
        var node = new Node(queue.poll());
        node.left = left;
        node.right = create(queue, half + 1, end);
        return node;
    }

    static String bfs(Node root) {
        var queue = new LinkedList<Node>();
        var sb = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                sb.append(node.value).append(" ");

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}
