import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[] inputNumbers;
    static int[] numbers;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inputNumbers = new int[n];
        numbers = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputNumbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputNumbers);

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

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[index] = inputNumbers[i];
                permutations(visited, index + 1);
                visited[i] = false;
            }
        }
    }
}
