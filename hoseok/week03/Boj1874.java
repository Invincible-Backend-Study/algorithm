/*
    스택에 항상 오름차순으로 숫자를 입력하므로
    스택의 top보다 큰 수라면 해당 수까지 push를하고 pop을 하면 된다.
    스택의 top과 다르다면 오름차순으로 숫자를 push했을때 나타날 수 없는 경우이므로 NO가 된다.
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

        int currentNumber = 1;
        while (n-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (number >= currentNumber) {
                for (int i = currentNumber; i <= number; i++) {
                    stack.push(i);
                    currentNumber++;
                    result.append("+\n");
                }
            } else if (!stack.isEmpty() && number != stack.peek()) {
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
            stack.pop();
            result.append("-\n");
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
