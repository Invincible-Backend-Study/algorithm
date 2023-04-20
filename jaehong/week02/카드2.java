/*
N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며,
1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.

제일 위에 있는 카드를 바닥에 버린다.
그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

queue의 poll, offer
*/

// 시간: 15:21

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Boj2164{

    public static void main(String...args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var input = Integer.parseInt(br.readLine());
        
        if(input == 1){
            System.out.println(1);
            return;
        }
        var queue = IntStream.range(1, input + 1)
          .mapToObj(Integer::valueOf)
          .collect(Collectors.toCollection(LinkedList::new));
      
        while(queue.size() > 2){
            queue.poll(); //drop card
            queue.offer(queue.poll());
        }
      
        queue.poll();
        System.out.println(queue.poll());
    }
}
