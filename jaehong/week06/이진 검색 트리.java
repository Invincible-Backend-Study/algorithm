import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj5639 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var queue = new ArrayDeque<Integer>();
        while (true) {
            if (!br.ready()) {
                break;
            }
            queue.offer(Integer.parseInt(br.readLine()));
        }

        System.out.println(postOrder(dfs(queue, queue.poll())));
    }

    static Node dfs(Queue<Integer> queue, Integer value) {
        if (value == null) {
            return null;
        }
        if (queue.isEmpty()) {
            return new Node(value);
        }

        var leftList = new ArrayDeque<Integer>();
        var rightList = new ArrayDeque<Integer>();

        while (!queue.isEmpty()) {
            var element = queue.poll();

            if (element > value) {
                rightList.offer(element);
            } else {
                leftList.offer(element);
            }
        }
        return new Node(value, dfs(leftList, leftList.poll()), dfs(rightList, rightList.poll()));
    }

    static String postOrder(Node node) {
        String value = "";
        if (node.left != null) {
            value += postOrder(node.left) + "\n";
        }
        if (node.right != null) {
            value += postOrder(node.right) + "\n";
        }
        return value + node.value;
    }

}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}
