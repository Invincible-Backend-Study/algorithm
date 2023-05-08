// 답안 참고함

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj7662 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            var inputCase = Integer.parseInt(br.readLine());
            var queue = new TreeMap<Integer, Integer>();

            while (inputCase-- > 0) {
                var st = new StringTokenizer(br.readLine());
                var command = st.nextToken();
                var value = Integer.parseInt(st.nextToken());

                if ("I".equals(command)) {
                    queue.put(value, queue.getOrDefault(value, 0) + 1);
                    continue;
                }

                if (queue.isEmpty()) {
                    continue;
                }

                // value 1(+), -1(-)
                var number = value == 1 ? queue.lastKey() : queue.firstKey();

                // 남은 개수가 1인 경우 삭제
                if (queue.put(number, queue.get(number) - 1) == 1) {
                    queue.remove(number);
                }
            }

            sb.append(queue.isEmpty() ? "EMPTY" : String.format("%d %d", queue.lastKey(), queue.firstKey())).append("\n");
        }

        System.out.println(sb);


    }
}

