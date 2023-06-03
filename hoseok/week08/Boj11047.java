import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[n];
        
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int coinCount = 0;
        int currentMoney = k;
        for (int i = n - 1; i >= 0; i--) {
            if (currentMoney == 0) {
                break;
            }
            if (currentMoney / coins[i] > 0) {
                coinCount += currentMoney / coins[i];
                currentMoney %= coins[i];
            }
        }
        
        bw.write(coinCount + "");
        bw.flush();
        bw.close();
    }
}
