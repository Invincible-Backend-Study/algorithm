import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long number = Long.parseLong(br.readLine());

        long l = 0;
        long r = (long) Math.sqrt(Long.MAX_VALUE) + 1;

        while (l < r) {
            long mid = (l + r) / 2;

            long target = mid * mid;

            if (target >= number) {
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
