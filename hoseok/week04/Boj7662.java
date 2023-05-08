/*
    I n: 정수 n을 큐에 삽입 (동일한 숫자가 주어질 수 있다.)
    D 1: 큐에서 최댓값을 poll
    D -1: 큐에서 최솟값은 poll
     D 연산에서 큐가 비어있다면 무시된다.

    큐에 저장되는 수는 32비트 정수이므로 int 타입으로 커버 가능

    두 개의 우선순위 큐를 만들고 하나는 최댓값, 다른 하나는 최솟값을 기준으로 정렬되게 한다.
    이후 Map자료형에 I로 입력되는 모든 정수들을 카운팅한다.

    큐에서 값을 꺼낼때마다 Map 자료형에서 해당 숫자에 해당되는 카운팅을 감소한다.
    만약 카운팅값이 0이라면 Map 자체에서 제거한다.
    
    이를 통해 다른 큐에서 이미 제거된 정수가 뽑히는경우를 검사할 수 있다.
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> numberCounts = new HashMap<>();
            PriorityQueue<Integer> maximum = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minimum = new PriorityQueue<>(Comparator.naturalOrder());

            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if (command.equals("I")) {
                    int number = Integer.parseInt(st.nextToken());
                    maximum.offer(number);
                    minimum.offer(number);
                    numberCounts.put(number, numberCounts.getOrDefault(number, 0) + 1);
                } else if (Integer.parseInt(st.nextToken()) == -1) {
                    removeNumber(minimum, numberCounts);
                } else {
                    removeNumber(maximum, numberCounts);
                }
            }

            if (numberCounts.isEmpty()) {
                result.append("EMPTY\n");
            } else {
                result.append(pollResult(numberCounts, maximum)).append(" ");
                result.append(pollResult(numberCounts, minimum)).append("\n");
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static int pollResult(Map<Integer, Integer> numberCounts, PriorityQueue<Integer> que) {
        int pollNumber = 0;
        while (!que.isEmpty()) {
            if (numberCounts.containsKey(que.peek())) {
                pollNumber = que.poll();
                break;
            }
            que.poll();
        }
        return pollNumber;
    }

    public static void removeNumber(PriorityQueue<Integer> que, Map<Integer, Integer> numberCounts) {
        while (!que.isEmpty()) {
            int number = que.poll();
            if (numberCounts.containsKey(number)) {
                int countedNumber = numberCounts.get(number) - 1;
                if (countedNumber == 0) {
                    numberCounts.remove(number);
                } else {
                    numberCounts.put(number, countedNumber);
                }
                break;
            }
        }
    }
}
