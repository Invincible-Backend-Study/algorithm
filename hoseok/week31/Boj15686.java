import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int calcDistance(Node node) {
            return Math.abs(r - node.r) + Math.abs(c - node.c);
        }
    }

    static int n, m, minDistance = Integer.MAX_VALUE;
    static List<Node> houses = new ArrayList<>();
    static List<Node> chickens = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 1) {
                    houses.add(new Node(i, j));
                } else if (number == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[chickens.size()];
        combinations(0, m);

        bw.write(minDistance + "");
        bw.flush();
        bw.close();
    }

    public static void combinations(int index, int r) {
        if (r == 0) {
            updateDistance();
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            visited[i] = true;
            combinations(i + 1, r - 1);
            visited[i] = false;
        }
    }

    public static void updateDistance() {
        int totalMinDistance = 0;
        for (Node house : houses) {
            int curMinDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (visited[i]) {
                    curMinDistance = Math.min(house.calcDistance(chickens.get(i)), curMinDistance);
                }
            }
            totalMinDistance += curMinDistance;
        }
        minDistance = Math.min(totalMinDistance, minDistance);
    }
}
