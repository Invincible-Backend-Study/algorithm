/*
    트리를 연결리스트 구조로 저장을하고,
    주어지는 간선을 순서에 맞춰서 별도로 저장한다.

    단절점을 구분하는 방법(숫자 1)
    지우고자 하는 정점이 2개 이상의 간선과 연결되어 있다면 지웠을때 2개의 그래프 생성이 보장된다.
    따라서 yest
    반대로 정점이 2개 미만의 간선과 연결되어있거나 간선이 없는 경우 no

    단절선을 구분하는 방법(숫자2)
    우선 간선이 있다는것 자체의 의미를 생각해보면 2개이상의 정점이 연결되어 있다는 의미이므로
    어떤 간선을 지우든 yes다.
*/

import java.io.*;
import java.util.*;

class Main {
    private static int[][] edges;
    private static List<Integer>[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        edges = new int[n][2];
        trees = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            trees[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startVertex = Integer.parseInt(st.nextToken());
            int endVertex = Integer.parseInt(st.nextToken());
            edges[i][0] = startVertex;
            edges[i][1] = endVertex;
            trees[startVertex].add(endVertex);
            trees[endVertex].add(startVertex);
        }

        StringBuilder result = new StringBuilder();
        int questionCount = Integer.parseInt(br.readLine());
        while (questionCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if (command == 1) {
                if (trees[number].size() < 2) {
                    result.append("no\n");
                } else {
                    result.append("yes\n");
                }
            } else {
                result.append("yes\n");
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
