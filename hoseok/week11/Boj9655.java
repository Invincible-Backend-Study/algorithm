/*
    간단 풀이
    
    돌을 무조건 홀수개로 가져가고, 상근이가 항상 먼저 시작합니다.
    
    따라서 마지막 돌이 홀수번째라면 반드시 상근이가 이기게 되고 짝수번째라면 창영이가 이깁니다.
    
    1 2 3 4 5 6 7 8 9 10                        
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        if (n % 2 == 0) {
            bw.write("CY");
        } else {
            bw.write("SK");
        }
        bw.flush();
        bw.close();
    }
}


/*

    DP 풀이
    
    게임을 계속 완벽하게 했을때
    1: 상근 승 (1개 가져감)
    2: 창영 승
    3: 상근 승
    
    위와 같이 상근과 창영의 승리가 서로 주고받게 됩니다. (홀수개만 빼게 되므로)
    
    따라서 dp[n] = dp[n - 1]의 반대값이 승리가 되므로 boolean을 통해 간단히 구할 수 있습니다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n + 1];
        
        dp[1] = true;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = !dp[i  - 1];
        }
        
        if (dp[n]) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }
        bw.flush();
        bw.close();
    }
}
