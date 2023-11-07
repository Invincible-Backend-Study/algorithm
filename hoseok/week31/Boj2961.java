/*
    요리를 만들 수 있는 모든 조합을 구하고, 신맛과 쓴맛을 곱, 더해가면서 모든 경우의 수를 구합니다.
    10개중에서 모든 조합을 구성해야 하므로 2^10 = 1024로 선형적인 시간내에 탐색할 수 있습니다.
*/
import java.io.*;
import java.util.*;

class Main {
    
    private static int n;
    private static int[] sours, bitters;
    private static int minDifference = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        sours = new int[n];
        bitters = new int[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sours[i] = Integer.parseInt(st.nextToken());
            bitters[i] = Integer.parseInt(st.nextToken());
        }
        
        backtracking(0, 0, 1, 0);
        
        bw.write(minDifference + "");
        bw.flush();
        bw.close();
    }
    
    public static void backtracking(int index, int count, int sour, int bitter) {
        if (index == n) {
            if (count > 0) {
                minDifference = Math.min(Math.abs(sour - bitter), minDifference);
            }
            return;
        }
        
        backtracking(index + 1, count + 1, sour * sours[index], bitter + bitters[index]);
        backtracking(index + 1, count, sour, bitter);
    }
}
