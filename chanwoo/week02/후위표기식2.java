import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 1935번
 */
public class Main {

    private static final Stack<Character> operationStack = new Stack<>();
    private static final Stack<Double> operandStack = new Stack<>();
    public static final int CHARACTER_A_ASCII_CODE = 65;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] value = new int[n];
        String postfixExpression = br.readLine();

        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < postfixExpression.length(); i++) {
            char bitOfExpression = postfixExpression.charAt(i);
            if (isOperation(bitOfExpression)) {
                operationStack.push(bitOfExpression);
                calculate();
                continue;
            }
            operandStack.push((double) value[bitOfExpression - CHARACTER_A_ASCII_CODE]);
        }

        Double result = operandStack.pop();
        bw.write(String.format("%.2f", result));
        bw.flush();
        bw.close();
    }

    public static boolean isOperation(char bit) {
        if (Character.isAlphabetic(bit)) {
            return false;
        }
        return true;
    }

    public static void calculate() {
        Double rightOperand = operandStack.pop();
        Double leftOperand = operandStack.pop();
        Character operation = operationStack.pop();

        double result = operate(leftOperand, rightOperand, operation);
        operandStack.push(result);
    }

    private static double operate(Double leftOperand, Double rightOperand, Character operation) {
        switch (operation) {
            case '+': {
                return leftOperand + rightOperand;
            }
            case '-': {
                return leftOperand - rightOperand;
            }
            case '*': {
                return leftOperand * rightOperand;
            }
            case '/': {
                return leftOperand / rightOperand;
            }
        }
        return 0;
    }
}
