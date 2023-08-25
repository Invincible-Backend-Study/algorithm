import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] aAndB = new int[n * n];
        int[] cAndD = new int[n * n];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aAndB[index] = A[i] + B[j];
                cAndD[index++] = C[i] + D[j];
            }
        }

        Arrays.sort(aAndB);
        Arrays.sort(cAndD);

        long count = 0;
        int l = 0;
        int r = n * n - 1;
        while (l < n * n && r > -1) {
            int result = aAndB[l] + cAndD[r];

            if (result == 0) {
                long lCount = 0;
                int lValue = aAndB[l];
                while (l < n * n && aAndB[l] == lValue) {
                    lCount++;
                    l++;
                }

                long rCount = 0;
                int rValue = cAndD[r];
                while (r > -1 && cAndD[r] == rValue) {
                    rCount++;
                    r--;
                }
                
                count += lCount * rCount;
            } else if (result > 0) {
                r--;
            } else {
                l++;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
