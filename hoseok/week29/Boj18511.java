import java.io.*;
import java.util.*;

class Main {

    private static int n, k, max;
    private static int[] numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        numbers = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        recur(0);

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static void recur(int number) {
        if (number > n) {
            return;
        }
        max = Math.max(max, number);

        for (int nextNumber : numbers) {
            recur(number * 10 + nextNumber);
        }
    }
}
