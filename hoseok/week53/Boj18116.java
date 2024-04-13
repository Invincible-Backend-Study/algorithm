import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] parents;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        parents = new int[1_000_001];
        count = new int[1_000_001];
        for (int i = 1; i <= 1_000_000; i++) {
            parents[i] = i;
            count[i] = 1;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.nextToken().charAt(0) == 'I') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                int findNumber = find(Integer.parseInt(st.nextToken()));
                answer.append(count[findNumber]).append("\n");
            }
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (a > b) {
            parents[a] = b;
            count[b] += count[a];
        } else {
            parents[b] = a;
            count[a] += count[b];
        }
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}
