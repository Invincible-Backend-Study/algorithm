/*
    Node를 생성하고, 이름을 Key로 Node를 value로 두고 Map에 저장한다.
    각 Node는 왼쪽, 오른쪽 자식을 가지고 있다. 왼쪽, 오른쪽 자식은 이름을 저장한다.
    이후 순서에 맞게 재귀 탐색을 한다.
*/

import java.io.*;
import java.util.*;

class Main {

    static class Node {
        String left, right;

        public Node(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }

    private static Map<String, Node> trees = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = n;
        while (count-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            trees.put(name, new Node(left, right));
        }

        StringBuilder result = new StringBuilder();

        boolean[] visited = new boolean[n];
        preOrder("A", result, visited);
        result.append("\n");
        visited = new boolean[n];
        inOrder("A", result, visited);
        result.append("\n");
        visited = new boolean[n];
        postOrder("A", result, visited);

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void postOrder(String name, StringBuilder result, boolean[] visited) {
        if (name.equals(".")) {
            return;
        }
        Node node = trees.get(name);
        postOrder(node.left, result, visited);
        postOrder(node.right, result, visited);
        visited[name.charAt(0) - 'A'] = true;
        result.append(name);
    }

    public static void inOrder(String name, StringBuilder result, boolean[] visited) {
        if (name.equals(".")) {
            return;
        }
        Node node = trees.get(name);
        inOrder(node.left, result, visited);
        visited[name.charAt(0) - 'A'] = true;
        result.append(name);
        inOrder(node.right, result, visited);
    }

    public static void preOrder(String name, StringBuilder result, boolean[] visited) {
        if (name.equals(".")) {
            return;
        }
        Node node = trees.get(name);
        result.append(name);
        visited[name.charAt(0) - 'A'] = true;
        preOrder(node.left, result, visited);
        preOrder(node.right, result, visited);
    }
}
