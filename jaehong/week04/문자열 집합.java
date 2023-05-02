import java.util.*;
import java.io.*;

public class Boj14425{
    public static void main(String...args)throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        var N = Integer.parseInt(st.nextToken());
        var M = Integer.parseInt(st.nextToken());

        var nSet = new HashSet<String>();
        var answer = 0;

        while(N-- > 0) {
            nSet.add(br.readLine());
        }

        while(M-- > 0){
            answer += nSet.contains(br.readLine()) ? 1 : 0;
        }
        System.out.println(answer);
    }
}
