import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        char[] numbers = line.toCharArray();
        Stack<Integer> stack = new Stack<>();

        int popCount = 0;
        for (int i = 0; i < n; i++) {
            int number = numbers[i] - '0';
            while (popCount < k && !stack.isEmpty() && stack.peek() < number) {
                stack.pop();
                popCount++;
            }
            stack.push(number);
        }
        while (popCount < k) {
            stack.pop();
            popCount++;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        bw.write(result.reverse().toString());
        bw.flush();
        bw.close();
    }
}
