import java.io.*;
import java.util.*;

class Main {
    
    static int n, s, count;
    static int[] numbers;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        allCombinations(0, 0);
       
        if (s == 0) {
            count--;
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
    
    public static void allCombinations(int index, int sum) {
        if (index == n) {
            if (sum == s) {
                count++;
            }
            return;
        }
        allCombinations(index + 1, sum + numbers[index]);
        allCombinations(index + 1, sum);
    }
}
