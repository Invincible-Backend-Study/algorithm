/*
    역순으로 나눈다.
    1. 2로 나누어 떨어지면 나눈다.
    2. 2로 나누어 떨어지지 않는다면 10으로 나눈 나머지가 1(끝자리가 1이라면) 10으로 숫자를 나눈다.

    1, 2 연산을 하기전에 현재숫자가 돌아가야 하는 숫자를 거치지 않고 더 작아지거나
    홀수인데 끝자리가 1이 아니라면 -1을 출력한다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 0;

        while (true) {
            if (B == A) {
                break;
            }
            if (B < A) {
                bw.write("-1");
                bw.flush();
                bw.close();
                return;
            }
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                bw.write("-1");
                bw.flush();
                bw.close();
                return;
            }
            count++;
        }

        bw.write((count + 1) + "");
        bw.flush();
        bw.close();
    }
}
