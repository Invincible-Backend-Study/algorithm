import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] nArr = new int[n];
        int[] mArr = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder result = new StringBuilder();
        int nIdx = 0;
        int mIdx = 0;
        while (nIdx < n && mIdx < m) {
            if (nArr[nIdx] > mArr[mIdx]) {
                result.append(mArr[mIdx++]).append(" ");
            } else {
                result.append(nArr[nIdx++]).append(" ");
            }
        }
        
        while (nIdx < n) {
            result.append(nArr[nIdx++]).append(" ");
        }
        
        while (mIdx < m) {
            result.append(mArr[mIdx++]).append(" ");
        }
        
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
