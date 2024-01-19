import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        permutation(new boolean[n], new int[m], 0);

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void permutation(boolean[] visited, int[] numbers, int index) {
        if (index == m) {
            for (int number : numbers) {
                result.append(number).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[index] = i + 1;
                permutation(visited, numbers, index + 1);
                visited[i] = false;
            }
        }
    }
}
