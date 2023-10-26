import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] combination = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            combination[number1][number2] = true;
            combination[number2][number1] = true;
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (combination[i][j]) {
                    continue;
                }
                for (int k = j + 1; k <= n; k++) {
                    if (combination[i][k] || combination[j][k]) {
                        continue;
                    }
                    count++;
                }
            }
        }
        
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
