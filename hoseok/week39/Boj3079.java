import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        long l = 1;
        long r = (long) Math.pow(10, 18);
        
        while (l < r) {
            long mid = (l + r) / 2;
            
            long count = 0;
            for (int i = 0; i < n; i++) {
                count += mid / numbers[i];
                if (count >= m) {
                    break;
                }
            }
            
            if (count >= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        bw.write(l + "");
        bw.flush();
        bw.close();
    }
}
