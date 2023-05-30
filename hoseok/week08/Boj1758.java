/*
    내림차순 정렬을 하고
    가장 많이 주는 팁부터 받아야 최소 손실로 받을 수 있다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        long[] tips = new long[n + 1];
        
        for (int i = 1; i <= n; i++) {
            tips[i] = Long.parseLong(br.readLine());
        }        
        Arrays.sort(tips);
        
        long sum = 0;
        for (int i = n; i >= 0; i--) {
            long tip = tips[i] - (n - i);
            if (tip >= 0) {
                sum += tip;
            }
        }
        
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
