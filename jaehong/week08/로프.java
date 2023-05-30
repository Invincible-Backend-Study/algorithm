import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj2217 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var queue = new PriorityQueue<Integer>((a, b) -> b - a);
        var n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            var w = Integer.parseInt(br.readLine());
            queue.offer(w);
        }
      
        var max = queue.poll();
        var count = 2;
      
        while (!queue.isEmpty()) {
            var w = queue.poll();
            var divisionWeight = w * count++;
            if (divisionWeight > max) {
                max = Math.max(divisionWeight, max);
            }
        }
        System.out.println(max);
    }
}
