import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int groupCount = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int[] diffs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diffs[i] = heights[i + 1] - heights[i];
        }
        
        Arrays.sort(diffs);
        
        int sum = 0;
        for (int i = 0; i < n - groupCount; i++) {
            sum += diffs[i];
        }
        
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
