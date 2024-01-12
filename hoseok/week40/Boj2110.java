import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            max = Math.max(numbers[i], max);
        }

        Arrays.sort(numbers);

        int l = 0;
        int r = max + 1;
        while (l < r) {
            int mid = (l + r) / 2;


            int count = 1;
            int lastHome = numbers[0];
            for (int i = 1; i < n; i++) {
                if (numbers[i] - lastHome >= mid) {
                    count++;
                    lastHome = numbers[i];
                }
            }

            if (c > count) {
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
