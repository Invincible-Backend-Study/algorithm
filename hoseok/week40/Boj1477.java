import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        numbers[N + 1] = L;
        Arrays.sort(numbers);
        
        // mid는 휴게소 사이에 새로 지을 휴게소간 거리가 됨
        int l = 1;
        int r = L - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            
            int count = 0;
            for (int i = 1; i <= N + 1; i++) {
                // 휴게소 사이의 거리가 mid와 동일하면 numbers[i]위치에 휴게소를 짓게 되므로 1을 빼주어야 함
                count += (numbers[i] - numbers[i - 1] - 1) / mid;
            }
            
            if (M >= count) {
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
