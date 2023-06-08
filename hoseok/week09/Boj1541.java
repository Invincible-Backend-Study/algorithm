/*
    50 - 40 + 50
    뺄셈뒤에 덧셈이 나오는 경우 덧셈을 전부 계산하고 뺼셈을 해야 가장 큰 수를 빼기에 최소 결과가 나온다.

    50 + 50 - 40
    덧셈이 먼저나오고 뺄셈이 나온다면 계산 순서에 상관없이 동일한 결과가 나타난다.

    따라서 덧셈을 우선적으로 게산하고 이후 뺄셈을 계산한다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, "-");
        int sum = Integer.MIN_VALUE;
        while (st.hasMoreTokens()){
            String plus = st.nextToken();
            int plusResult = calculatePlus(plus);
            if (sum == Integer.MIN_VALUE) {
                sum = plusResult;
            } else {
                sum -= plusResult;
            }
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }

    public static int calculatePlus(String line) {
        StringTokenizer st = new StringTokenizer(line, "+");
        int sum = 0;
        if (st.countTokens() > 1) {
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }
            return sum;
        }
        return Integer.parseInt(st.nextToken());
    }
}
