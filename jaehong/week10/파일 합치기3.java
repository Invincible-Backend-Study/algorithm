import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj13975 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            var N = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine());
            var queue = new PriorityQueue<Long>();

            while (st.hasMoreTokens()) {
                queue.offer(Long.parseLong(st.nextToken()));
            }

            var sum = 0L;

            while (queue.size() > 1) {
                var result = queue.poll() + queue.poll();
                sum += result;
                queue.offer(result);
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
