/*
    push X: 정수 X를 큐에 넣는 연산이다.
    pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 큐에 들어있는 정수의 개수를 출력한다.
    empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                dq.offer(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (dq.isEmpty()) {
                    result.append("-1\n");
                } else {
                    result.append(dq.poll()).append("\n");
                }
            } else if (command.equals("size")) {
                result.append(dq.size()).append("\n");
            } else if (command.equals("empty")) {
                if (dq.isEmpty()) {
                    result.append("1\n");
                } else {
                    result.append("0\n");
                }
            } else if (command.equals("front")) {
                if (dq.isEmpty()) {
                    result.append("-1\n");
                } else {
                    result.append(dq.peekFirst()).append("\n");
                }
            } else {
                if (dq.isEmpty()) {
                    result.append("-1\n");
                } else {
                    result.append(dq.peekLast()).append("\n");
                }
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
