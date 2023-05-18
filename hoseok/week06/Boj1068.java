/*
    트리의 방향이 부모 -> 자식으로 흐름이 흐르도록해야하므로 단방향 연결리스트로 만든다.

    이후 주어진 노드 번호에 해당하는 리스트를 전부 삭제한다.
    이때 자식의 자식의 자식까지 즉, 끝까지 삭제해야 하므로 재귀를 돌면서 삭제한다.
    
    이후 DFS를 돌면서 돌면서 다음을 만족하면 리프노드가 된다.
    1. 해당 노드 번호의 리스트가 비어있는경우
    2. 해당 노드 번호의 자식 노드가 1개 있지만 삭제된 노드인 경우 
       (삭제할 노드의 하위 연결은 모두 지웠지만, 부모 노드의 자식 노드 리스트에는 남아있으므로 검사해야함)
*/
import java.io.*;
import java.util.*;

class Main {
    private static List<Integer>[] trees;
    private static int leafCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        trees = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            trees[i] = new ArrayList<>();
        }

        int rootNode = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number != -1) {
                trees[number].add(i);
            } else {
                rootNode = i;
            }
        }
        int removeNumber = Integer.parseInt(br.readLine());
        removeTree(removeNumber);

        searchLeafNode(rootNode);

        bw.write(leafCount + "");
        bw.flush();
        bw.close();
    }

    public static void searchLeafNode(int node) {
        if (trees[node] == null) {
            return;
        }
        if (trees[node].isEmpty() 
            || trees[node].size() == 1 && trees[trees[node].get(0)] == null) {
            leafCount++;
            return;
        }

        for (int nextNode : trees[node]) {
            searchLeafNode(nextNode);
        }
    }

    public static void removeTree(int removeNumber) {
        if (trees[removeNumber].size() == 0) {
            trees[removeNumber] = null;
            return;
        }
        for (int number : trees[removeNumber]) {
            removeTree(number);
        }
        trees[removeNumber] = null;
    }
}
