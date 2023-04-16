/*
    단순 스택 구현
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();

            if (operator.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (operator.equals("pop")) {
                if (stack.isEmpty()) {
                    result.append("-1\n");
                } else {
                    result.append(stack.pop()).append("\n");
                }
            } else if (operator.equals("size")) {
                result.append(stack.size()).append("\n");
            } else if (operator.equals("empty")) {
                if (stack.isEmpty()) {
                    result.append("1\n");
                } else {
                    result.append("0\n");
                }
            } else {
                if (stack.isEmpty()) {
                    result.append("-1\n");
                } else {
                    result.append(stack.peek()).append("\n");
                }
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
