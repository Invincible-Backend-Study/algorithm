/*
    후위 표기식은 스택하나로 계산이 가능
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        Stack<Double> stack = new Stack<>();

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (char input : line.toCharArray()) {
            if (input >= 65 && input <= 90) {
                stack.push((double) numbers[input - 'A']);
            } else {
                stack.push(calculate(stack.pop(), stack.pop(), input));
            }
        }

        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
        bw.close();
    }

    public static double calculate(double op2, double op1, char operator) {
        if (operator == '+') {
            return op1 + op2;
        }
        if (operator == '-') {
            return op1 - op2;
        }
        if (operator == '/') {
            return op1 / op2;
        }
        return op1 * op2;
    }
}
