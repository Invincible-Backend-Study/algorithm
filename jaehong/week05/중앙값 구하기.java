import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2696 {

    public static void main(String... args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            var size = Integer.parseInt(br.readLine());
            var st = new StringTokenizer(br.readLine());

            var left = new PriorityQueue<Integer>(Collections.reverseOrder());
            var right = new PriorityQueue<Integer>();

            var median = Integer.parseInt(st.nextToken());
            var temp = new StringBuilder();
            var count = 1;
            temp.append(median).append(" ");

            for (int i = 2; i <= size; i++) {
                if (i >= 10 && (i - 1) % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                var input = Integer.parseInt(st.nextToken());
                if (median < input) {
                    right.offer(input);
                } else {
                    left.offer(input);
                }

                // 짝수
                if (i % 2 == 0) {
                    continue;
                }

                var moveCount = left.size() - right.size();
                count++;
                if (moveCount > 0) {
                    right.offer(median);
                    while (moveCount-- > 0) {
                        right.offer(left.poll());
                    }
                    median = right.poll();
                }
                if (moveCount < 0) {
                    left.offer(median);

                    while (moveCount++ > 0) {
                        left.offer(right.poll());
                    }
                    median = right.poll();
                }

                temp.append(median).append(" ");
            }
            sb.append(count)
                    .append("\n")
                    .append(temp)
                    .append("\n");
        }
        System.out.print(sb);
    }
}
