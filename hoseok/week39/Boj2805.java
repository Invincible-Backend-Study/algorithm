import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        long l = 0;
        long r = 1_000_000_000L;
        while (l < r) {
            long mid = (l + r) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.max(0, trees[i] - mid);
            }
            if (m > sum) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        bw.write((l - 1) + "");
        bw.flush();
        bw.close();
    }
}
