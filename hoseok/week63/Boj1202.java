import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node> {
        int weight, cost;

        public Node(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            if (weight == n.weight) {
                return n.cost - cost;
            }
            return weight - n.weight;
        }
    }

    static int n, k;
    static int[] bags;
    static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nodes = new Node[n];
        bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nodes);
        Arrays.sort(bags);

        long answer = 0;
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            while (index < n && bags[i] >= nodes[index].weight) {
                pq.offer(nodes[index].cost);
                index++;
            }
            if (!pq.isEmpty()) {
                int poll = pq.poll();
                answer += poll;
            }
        }
        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
    }
}
