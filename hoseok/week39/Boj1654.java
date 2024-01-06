import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[] lines = new int[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        
        // 랜섬의 범위는 자연수
        long l = 1L;
        long r = Integer.MAX_VALUE + 1L;
        while (l < r) {
            long mid = (l + r) / 2;
            
            long count = 0;
            for (int i = 0; i < k; i++) {
                count += lines[i] / mid;
            }
            
            if (n > count) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        bw.write((l - 1) + "");
        bw.flush();
        bw.close();
    }
}
