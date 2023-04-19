/*
   7,3 <- input
   7 -> 전체 인원수
   3 -> 제거 순번

   큐로 뺐다가 넣으면 될듯
 */

// 22:13

import java.io.*;
import java.util.*;

public class Boj1158{

    public static void main(String...args) throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        var queue = new LinkedList<Integer>();
        var inputs= br.readLine().split(" ");

        var count = Integer.parseInt(inputs[0]); // 전체 인원수
        var orderOfRemoval = Integer.parseInt(inputs[1]);// 제거 순번

        // 초기화
        for(int i = 1; i <= count; i++){
            queue.add(i);
        }

        int repeatCount = 1;
        while(queue.size() > 0){
            var element = queue.poll();

            if(repeatCount++ == orderOfRemoval){
                sb.append(element);
                if(queue.size() != 0){
                    sb.append(", ");
                }

                repeatCount= 1;
                continue;
            }

            queue.add(element);
        }

        System.out.println(String.format("<%s>", sb) );
    }
}
