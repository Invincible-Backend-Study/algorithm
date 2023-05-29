/*
    홀수로는 절대 만들 수 없다. 따라서 짝수일때를 검증한다.
*/

import java.io.*;

class Main {
    private static final String POLYOMINO1 = "AAAA";
    private static final String POLYOMINO2 = "BB";
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        
        int count = 0;
        for (char symbol : line.toCharArray()) {
            if (symbol == 'X') {
                count++;
            } else {
                if (count % 2 == 1) {
                    bw.write("-1");
                    bw.flush();
                    bw.close();
                    return;
                }
                appendPolyomino(count);
                count = 0;
                result.append(symbol);
            }
        }
        
        if (count % 2 == 1) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }
        appendPolyomino(count);
        
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
    
    public static void appendPolyomino(int count) {
        if (count >= 4) {
            for (int i = 0; i < count / 4; i++) {
                result.append(POLYOMINO1);
            }
            for (int i = 0; i < count % 4 / 2; i++) {
                result.append(POLYOMINO2);
            }
        } else {
            for (int i = 0; i < count / 2; i++) {
                result.append(POLYOMINO2);
            }
        }
    }
}
