/*
 * 시도 메모리 시간
 * 1 339208	1940
 * 2 244844	960
 * 3 244184	948
 * 4 217200	872
 * 5 209716	720
 * 6 96052	512
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String... args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var queue = new PriorityQueue<Integer>();
        var numberOfLine = Integer.parseInt(br.readLine());
        var stack = new Stack<String>();

        // 역순으로 처리 하기 위해서 입력을 스택에 저장함
        for (int i = 0; i < numberOfLine; i++) {
            stack.push(br.readLine());
        }

        for (int j = 0; j < numberOfLine; j++) {
            var st = new StringTokenizer(stack.pop());
            // 첫 줄의 경우 전부 집어넣음
            if (j == 0) {
                for (int i = 0; i < numberOfLine; i++) {
                    var element = Integer.parseInt(st.nextToken());
                    queue.offer(element);

                }
                continue;
            }

            var flagCount = 0;
            for (int i = 0; i < numberOfLine; i++) {
                var element = Integer.parseInt(st.nextToken());
                // 데이터를 넣기 전에 큐에서 가장 작은 숫자가 입력할 숫자보다 큰 숫자 인지 검증
                // 큐에서 가장 작은 수가 입력할 요소보다 큰 경우 flagCount를 1올리고 다음 숫자로 넘어감
                if (queue.peek() > element) {
                    flagCount++;
                    continue;
                }
                // 큐에서 가장 작은 숫자보다 큰 숫자라면 집어넣고 가장 작은 숫자를 뺌
                queue.offer(element);
                queue.poll();
            }
            // 이전에 검사한 flagCount가 N와 같은 값인 경우 종료함
            // 큐에서 가장 작은 숫자가 한 줄의 모든 숫자보다 크다면 그 위의 숫자는 한줄의 숫자보다 작은 값들만 있기 때문에 바로 종료함
            if (flagCount == numberOfLine) {
                break;
            }
        }

        System.out.println(queue.poll());


    }
}
