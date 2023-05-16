import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj9934 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var queue = new ArrayDeque<Integer>();
        var size = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        System.out.print(bfs(create(queue, 0, queue.size() - 1)));
    }

    static Node create(ArrayDeque<Integer> queue, int start, int end) {
        if (end - start == 2) {
            return new Node(queue.poll(), queue.poll(), queue.poll());
        }
        var half = (start + end) / 2;
        return new Node(create(queue, start, half - 1), queue.poll(), create(queue, half + 1, end));
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

    Node(int left, int mid, int right) {
        this(new Node(left), mid, new Node(right));
    }

    Node(Node left, int mid, Node right) {
        this.value = mid;
        this.left = left;
        this.right = right;
    }

    Node(int value) {
        this.value = value;
    }
}
