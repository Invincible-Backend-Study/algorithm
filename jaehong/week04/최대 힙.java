
import java.util.*;
import java.io.*;

public class Boj11279{

    public static void main(String...args)throws Exception{

        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var queue = new PriorityQueue<Integer>(Collections.reverseOrder());


        var testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0 ){
            var input = Integer.parseInt(br.readLine());

            if(input == 0){
                sb.append(queue.size() == 0 ? 0 : queue.poll()).append("\n");
                continue;
            }

            queue.offer(input);
        }

        System.out.print(sb);

    }
}
