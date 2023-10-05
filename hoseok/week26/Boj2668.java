import java.io.*;
import java.util.*;

class Main {

    private static int[] numbers;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            if (dfs(i, i)) {
                results.add(i);
            }
        }

        results.sort(Comparator.naturalOrder());

        bw.write(results.size() + "\n");
        for (int result : results) {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean dfs(int startNumber, int number) {
        if (visited[number] && startNumber == number) {
            return true;
        } else if (visited[number]) {
            return false;
        }
        visited[number] = true;
        return dfs(startNumber, numbers[number]);
    }
}
