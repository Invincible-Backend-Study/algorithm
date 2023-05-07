import java.io.*;
import java.util.*;

public class Boj11286{
    public static void main(String...args) throws Exception{

        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var numberOfInput = Integer.parseInt(br.readLine());

        var queue = new PriorityQueue<Integer>( (Integer a, Integer b) -> {
            var A = Math.abs(a);
            var B = Math.abs(b);
            if(A > B) {
                return A - B;
            }
            if(A == B){
                if(a > b) {
                    return 1;
                }
                return -1;
            }
            return -1;
        });


        while(numberOfInput-- > 0){
            var input = Integer.parseInt(br.readLine());

            if(input == 0){
                sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
                continue;
            }

            queue.offer(input);
        }



        System.out.println(sb);
    }
}

