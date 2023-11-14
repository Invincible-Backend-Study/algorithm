// 조합 + BFS
import java.io.*;
import java.util.*;

class Main {

    private static int n, m, minDistance = Integer.MAX_VALUE;
    private static int[] chickens = new int[2];
    private static int[] resultChickens = new int[2];
    private static List<Integer>[] graphs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graphs = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graphs[s].add(e);
            graphs[e].add(s);
        }

        combinations(1, 0);

        bw.write(resultChickens[0] + " " + resultChickens[1] + " " + minDistance);
        bw.flush();
        bw.close();
    }

    public static void combinations(int index, int count) {
        if (count == 2) {
            updateMinDistance();
            return;
        }

        for (int i = index; i <= n; i++) {
            chickens[count] = i;
            combinations(i + 1, count + 1);
        }
    }

    public static void updateMinDistance() {
        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[chickens[0]] = true;
        visited[chickens[1]] = true;

        Queue<Integer> que = new LinkedList<>();
        que.offer(chickens[0]);
        que.offer(chickens[1]);

        while (!que.isEmpty()) {
            int curNode = que.poll();

            for (int nextNode : graphs[curNode]) {
                if (!visited[nextNode]) {
                    distances[nextNode] = distances[curNode] + 1;
                    visited[nextNode] = true;
                    que.offer(nextNode);
                }
            }
        }

        int curDistanceSum = 0;
        for (int distance : distances) {
            curDistanceSum += distance * 2;
        }
        if (minDistance > curDistanceSum) {
            minDistance = curDistanceSum;
            resultChickens[0] = chickens[0];
            resultChickens[1] = chickens[1];
        }
    }
}

// 플로이드 워셜 + 조합
import java.io.*;
import java.util.*;

class Main {

    private static final int INF = 1_000_000;
    private static int n, m, minDistance = Integer.MAX_VALUE;
    private static int[] chickens = new int[2];
    private static int[] results = new int[2];
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s][e] = 1;
            map[e][s] = 1;
        }

        floyd();
        combinations(1, 0);

        bw.write(results[0] + " " + results[1] + " " + minDistance);
        bw.flush();
        bw.close();
    }

    public static void combinations(int index, int count) {
        if (count == 2) {
            updateDistance();
            return;
        }

        for (int i = index; i <= n; i++) {
            chickens[count] = i;
            combinations(i + 1, count + 1);
        }
    }

    public static void updateDistance() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i == chickens[0] || i == chickens[1]) {
                continue;
            }
            sum += Math.min(map[i][chickens[0]], map[i][chickens[1]]) * 2;
        }

        if (sum < minDistance) {
            minDistance = sum;
            results[0] = chickens[0];
            results[1] = chickens[1];
        }
    }

    public static void floyd() {
        for (int middle = 1; middle <= n; middle++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    if (map[from][to] > map[from][middle] + map[middle][to]) {
                        map[from][to] = map[from][middle] + map[middle][to];
                    }
                }
            }
        }
    }
}
