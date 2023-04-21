/*
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push_front")) {
                dq.offerFirst(Integer.parseInt(st.nextToken()));
            } else if (command.equals("push_back")) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop_front")) {
                if (dq.isEmpty()) {
                    result.append("-1\n");
                } else {
                    result.append(dq.pollFirst()).append("\n");
                }
            } else if (command.equals("pop_back")) {
                if (dq.isEmpty()) {
                    result.append("-1\n");
                } else {
                    result.append(dq.pollLast()).append("\n");
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
