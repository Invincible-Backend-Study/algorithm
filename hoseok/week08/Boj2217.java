import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] lopes = new int[n];

        for (int i = 0; i < n; i++) {
            lopes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lopes);

        int maxLimit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxLimit = Math.max(maxLimit, lopes[i] * (n - i));
        }

        bw.write(maxLimit + "");
        bw.flush();
        bw.close();
    }
}
