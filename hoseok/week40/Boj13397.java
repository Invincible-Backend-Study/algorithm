import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 10000;
        while (l < r) {
            int mid = (l + r) / 2;

            int curMin = Integer.MAX_VALUE;
            int curMax = Integer.MIN_VALUE;
            int count = 1;
            for (int i = 0; i < n; i++) {
                curMin = Math.min(curMin, numbers[i]);
                curMax = Math.max(curMax, numbers[i]);
                if (curMax - curMin > mid) {
                    count++;
                    curMin = numbers[i];
                    curMax = numbers[i];
                }
            }

            if (m >= count) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        bw.write(l + "");
        bw.flush();
        bw.close();
    }
}
