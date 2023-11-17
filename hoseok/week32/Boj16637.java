import java.io.*;
import java.util.*;

class Main {

    private static int n, max = Integer.MIN_VALUE;
    private static String line;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        line = br.readLine();

        dfs(0, 0);

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int index, int result) {
        if (index >= n) {
            max = Math.max(max, result);
            return;
        }
        
        char op;
        if (index == 0) {
            op = '+';
        } else {
            op = line.charAt(index - 1);
        }
        if (index + 2 < n) {
            int curBracketNumber = calculate(line.charAt(index) - '0', line.charAt(index + 1), line.charAt(index + 2) - '0');
            dfs(index + 4, calculate(result, op, curBracketNumber));
        }
        dfs(index + 2, calculate(result, op, line.charAt(index) - '0'));
    }

    public static int calculate(int op1, char symbol, int op2) {
        if (symbol == '+') {
            return op1 + op2;
        } else if (symbol == '-') {
            return op1 - op2;
        }
        return op1 * op2;
    }
}
