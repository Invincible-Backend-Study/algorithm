import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] numbers;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[m];

        combinations(0, 0);

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void combinations(int count, int index) {
        if (count == m) {
            for (int number : numbers) {
                result.append(number).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = index; i < n; i++) {
            numbers[count] = i + 1;
            combinations(count + 1, i + 1);
        }
    }
}
