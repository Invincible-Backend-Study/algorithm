import java.io.*;
import java.util.*;

class Main {
    
    static class Node implements Comparable<Node> {
        int number;
        double cost;

        public Node(int number, double cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Double.compare(cost, n.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;

    static int n, w;
    static double m;
    static int[][] point;
    static double[] dist;

    static Set<Integer>[] lines;
    static List<Node>[] graphs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        m = Double.parseDouble(br.readLine());
        point = new int[n][2];
        graphs = new ArrayList[n];
        dist = new double[n];
        lines = new Set[n];

        for (int i = 0; i < n; i++) {
            graphs[i] = new ArrayList<>();
            lines[i] = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[i][0] = x;
            point[i][1] = y;
        }

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            lines[a].add(b);
            lines[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (lines[i].contains(j)) {
                    graphs[i].add(new Node(j, 0));
                    graphs[j].add(new Node(i, 0));
                } else {
                    double distance = getDistance(point[i], point[j]);
                    graphs[i].add(new Node(j, distance));
                    graphs[j].add(new Node(i, distance));
                }
            }
        }

        Arrays.fill(dist, INF);
        dist[0] = 0;

        dijkstra();

        int answer = (int) (dist[n - 1] * 1000);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static double getDistance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.number]) {
                continue;
            }

            for (Node next : graphs[current.number]) {
                if (dist[next.number] > current.cost + next.cost) {
                    dist[next.number] = current.cost + next.cost;
                    pq.offer(new Node(next.number, dist[next.number]));
                }
            }
        }
    }
}
