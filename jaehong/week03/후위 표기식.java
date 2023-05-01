import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj1918 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine();

        var queue = new ArrayDeque<String>();

        // 괄호 제거
        for (var element : input.split("")) {

            // 닫힌 괄호를 만나는 경우
            if (")".equals(element)) {
                var list = new ArrayDeque<String>();
                while (!queue.isEmpty()) {
                    var queueElement = queue.pollLast();
                    if ("(".equals(queueElement)) {
                        break;
                    }

                    list.offerFirst(queueElement);
                }

                queue.offer(doProcess(list));
                continue;
            }
            queue.offer(element);
        }

        var result = doProcess(queue);
        System.out.println(result);

    }

    // string ? stack?
    public static String doProcess(Deque<String> queue) {

        var result = new ArrayDeque<String>();

        while (!queue.isEmpty()) {
            var element = queue.poll();

            if (!result.isEmpty()) {
                var last = result.getFirst();
                if ("*".equals(last) || "/".equals(last)) {
                    var operator = result.poll();
                    var v1 = result.poll();
                    result.push(v1 + element + operator);
                    continue;
                }
            }

            result.push(element);
        }

        while (result.size() > 1) {
            var v1 = result.pollLast();
            var operator = result.pollLast();
            var v2 = result.pollLast();
            result.offer(v1 + v2 + operator);
        }

        return result.poll();
    }
} 
