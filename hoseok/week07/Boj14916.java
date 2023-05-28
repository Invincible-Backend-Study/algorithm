/*
    1, 3의 경우만 거스름돈을 줄 수 없다.
    1. 5원으로 나누어 떨어지는 경우
    2. 5원으로 최대한 나누고, 2원으로 나누어 떨어지는 경우
    3. 2번에서 2원으로 나누어떨어지지 않는다면 5원하나를 제외하고 2원으로 변경
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 3) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }
        int count = 0;
        if (n % 5 == 0) {
            count += n / 5;
        } else if (n % 5 % 2 == 0) {
            count += n / 5;
            count += n % 5 / 2;
        } else {
            count += n / 5;
            count--;
            count += (n % 5 + 5) / 2;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
