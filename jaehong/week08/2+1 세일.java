import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj11508 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var N = Integer.parseInt(br.readLine());
        var queue = new PriorityQueue<Integer>((a, b) -> b - a);

        var n = N;
        while (n-- > 0) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        var sum = 0;
        var count = 1;
        while (!queue.isEmpty()) {
            var element = queue.poll();
            if (count++ % 3 == 0) {
                continue;
            }
            sum += element;
        }

        System.out.println(sum);
    }
}
