import java.io.*;
import java.util.*;

class Main {
    
    static int n, m;
    static int[] numbers;
    static StringBuilder result = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[m];
        
        dupPermutations(0);
        
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
    
    public static void dupPermutations(int index) {
        if (index == m) {
            for (int number : numbers) {
                result.append(number).append(" ");
            }
            result.append("\n");
            return;
        }
        
        for (int i = 0; i < n; i++) {
            numbers[index] = i + 1;
            dupPermutations(index + 1);
        }
    }
}
