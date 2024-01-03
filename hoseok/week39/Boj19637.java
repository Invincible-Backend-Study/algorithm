import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[] titleScores;
    static String[] titleNames;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        titleScores = new int[n];
        titleNames = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            titleNames[i] = st.nextToken();
            titleScores[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        while(m-- > 0) {
            int score = Integer.parseInt(br.readLine());
            result.append(titleNames[findIndex(score)]).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static int findIndex(int score) {
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            // lower bound
            if (titleScores[mid] >= score) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
