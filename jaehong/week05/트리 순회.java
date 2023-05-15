import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1991 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        var inputCase = Integer.parseInt(br.readLine());

        var tree = new Tree();
        while (inputCase-- > 0) {
            var line = br.readLine();

            tree.createNode(line.charAt(0), line.charAt(2), line.charAt(4));
        }
        System.out.println(tree.result());
    }
}

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}

class Tree {

    Node root;

    void createNode(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);

            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
            return;
        }
        createNode(root, data, leftData, rightData);
    }

    void createNode(Node root, char data, char leftData, char rightData) {
        if (root == null) {
            return;
        }
        if (root.data == data) {
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
            return;
        }
        createNode(root.left, data, leftData, rightData);
        createNode(root.right, data, leftData, rightData);
    }

    String preorder(Node node) {
        String value = String.valueOf(node.data);
        if (node.left != null) {
            value += preorder(node.left);
        }
        if (node.right != null) {
            value += preorder(node.right);
        }
        return value;
    }

    String inorder(Node node) {
        String value = "";
        if (node.left != null) {
            value += inorder(node.left);
        }
        value += node.data;
        if (node.right != null) {
            value += inorder(node.right);
        }
        return value;
    }

    String postorder(Node node) {
        String value = "";
        if (node.left != null) {
            value += postorder(node.left);
        }
        if (node.right != null) {
            value += postorder(node.right);
        }
        value += node.data;
        return value;
    }

    String result() {
        return preorder(root) + "\n"
                + inorder(root) + "\n"
                + postorder(root);
    }
}
