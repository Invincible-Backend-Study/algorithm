/*
    주어진 노드에 대한 정점들을 담는 리스트를 만들고
    BFS를 돌면서
    루트 노드인 1번 노드부터 돌면서 현재 노드에 연결되어있는 노드들의 부모노드를 현재 노드로 설정한다.
    이때 방문체크는 부모 노드가 이미 존재하는 노드라면 탐색하지 않는 방식으로 방문 체크를 한다.
*/
import java.io.*;
import java.util.*;

class Main {
    private static List<Integer>[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            tree[startNode].add(endNode);
            tree[endNode].add(startNode);
        }

        int[] visited = new int[n + 1];
        visited[1] = -1;
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);

        while (!que.isEmpty()) {
            int currentNode = que.poll();
            for (int nextNode : tree[currentNode]) {
                if (visited[nextNode] == 0) {
                    visited[nextNode] = currentNode;
                    que.offer(nextNode);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
