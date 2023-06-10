/*
    가장 큰 수 만들기
    연속된 M을 바로 숫자로 변환하지 않고 K를 만날때까지 누적하다가 변환한다.

    가장 작은 수 만들기
    연속된 M만을 숫자로 변환하고, K는 따로 계산한다.

    위 과정에서 K를 만날때마다 즉시 변환을 해주어야 한다.
    
    만약 마지막에 M이 남아있다면 최대출력을 위해서는 전부 1로 변경하고, 최소 출력을 위해서는 100~과 같은 형식으로 변환한다.

    주어지는 민겸수는 최대 3000까지 주어지므로 숫자를 변환하는 방식으로 하면 long타입도 커버가 불가능하다.
    따라서 카운팅을 통해 직접 숫자를 붙여준다.
*/

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();

        StringBuilder maxResult = new StringBuilder();
        StringBuilder minResult = new StringBuilder();
        int count = 0;
        for (char sep : line.toCharArray()) {
            if (sep == 'M') {
            count++;
            } else {
                maxResult.append("5");
                maxResult.append("0".repeat(Math.max(0, count)));
                if (count > 0) {
                    minResult.append("1");
                }
                minResult.append("0".repeat(Math.max(0, count - 1)));
                minResult.append("5");
                count = 0;
            }
        }
        if (count > 0) {
            minResult.append("1");
            maxResult.append("1");
            for (int i = 0; i < count - 1; i++) {
                minResult.append("0");
                maxResult.append("1");
            }
        }

        maxResult.append("\n");

        bw.write(maxResult.toString() + minResult.toString());
        bw.flush();
        bw.close();
    }
}
