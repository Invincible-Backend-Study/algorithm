import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if (n <= 2) {
            bw.write(n + "");
            bw.flush();
            bw.close();
            return;
        }
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int length = 2;
        for (int i = 0; i < n - 2; i++) {
            for (int j = n - 1; j > i + 1; j--) {
                if (numbers[i] + numbers[i + 1] > numbers[j]) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }

        bw.write(length + "");
        bw.flush();
        bw.close();
    }
}
