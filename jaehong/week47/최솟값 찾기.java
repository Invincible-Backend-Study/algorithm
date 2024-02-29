import java.util.*;
import java.io.*;

public class Main{
    public static void main(String...args) throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine()); 
        
        var n = Integer.parseInt(st.nextToken());
        var k = Integer.parseInt(st.nextToken());
        
        var deque = new ArrayDeque<int[]>();
        var sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            
            while(!deque.isEmpty() && deque.getLast()[0] > num) deque.removeLast();
            deque.addLast(new int[]{num, i});
            
            if(deque.getFirst()[1] <= i - k ) deque.removeFirst();
            sb.append(deque.getFirst()[0]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
