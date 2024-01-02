import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
        int total = Integer.parseInt(br.readLine());
        if (sum <= total) {
            bw.write(max + "");
            bw.flush();
            bw.close();
            return;
        }

        long l = 1;
        long r = max + 1;

        while (l < r) {
            long mid = (l + r) / 2;

            long curTotal = getTotal(mid);
            if (curTotal > total) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        bw.write((l - 1) + "");
        bw.flush();
        bw.close();
    }

    public static long getTotal(long upperPrice) {
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(arr[i], upperPrice);
        }
        return total;
    }
}
