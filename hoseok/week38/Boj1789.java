import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long s = Long.parseLong(br.readLine());
        
        long l = 1L;
        long r = s + 1L;
        
        while (l < r) {
            long mid = (l + r) / 2;
            
            long total = mid * (mid + 1) / 2;
            
            // Upper Bound, total이 s보다 작거나 같을때 mid + 1의 값을 l에 주입하여 결국 찾고자 하는 값 보다 하나 더 큰 값을 나타냅니다.
            if (total > s) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // 따라서 최종 출력은 l값에서 -1 을해 찾고자 하는 답이 됩니다.
        bw.write((l - 1) + "");
        bw.flush();
        bw.close();
    }
}
