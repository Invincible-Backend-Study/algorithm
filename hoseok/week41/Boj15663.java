import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[] input;
    static int[] numbers;
    static Set<String> noneDup = new HashSet<>();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        numbers = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        permutations(new boolean[n], 0);

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void permutations(boolean[] visited, int index) {
        if (index == m) {
            for (int number : numbers) {
                result.append(number).append(" ");
            }
            result.append("\n");
            return;
        }
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && pre != input[i]) {
                pre = input[i];
                visited[i] = true;
                numbers[index] = input[i];
                permutations(visited, index + 1);
                visited[i] = false;
            }
        }
    }
}
