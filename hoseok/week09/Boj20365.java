/*
    최소로 칠하기 위해서는 연속적으로 동일하게 칠해져있는 색깔을 하나의 덩어리로 보고
    색깔 조각을 나눈 후 더 많은 색깔 조각이 있는 색깔로 전체를 칠한다.
    
    이후 다른 색깔 조각들을 하나씩 칠해주면 된다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        
        
        int blueCount = new StringTokenizer(line, "R").countTokens();
        int redCount = new StringTokenizer(line, "B").countTokens();
        
        int count = 0;
        if (blueCount > redCount) {
            count += 1 + redCount;
        } else {
            count += 1 + blueCount;
        }
        
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
