import java.io.*;
import java.util.*;

class Main {
    private static int[] numbers;
    private static boolean[] visited;
    private static Set<String> counts = new HashSet<>();;
    private static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        numbers = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        permutation("", 0);

        bw.write(counts.size() + "");
        bw.flush();
        bw.close();
    }

    public static void permutation(String number, int count) {
        if (count == k) {
            counts.add(number);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(number + numbers[i], count + 1);
                visited[i] = false;
            }
        }
    }
}
