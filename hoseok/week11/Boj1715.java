import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        long totalSum = 0;
        while (n-- > 0) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        while (pq.size() > 1) {
            long sum = pq.poll() + pq.poll();
            totalSum += sum;
            pq.offer(sum);
        }

        bw.write(totalSum + "");
        bw.flush();
        bw.close();
    }
}
