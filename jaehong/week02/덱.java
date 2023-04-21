/*
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

import java.io.*;
import java.util.*;
public class Boj10866{

    public static void main(String...args)throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var deque = new ArrayDeque<Integer>();
      
        var numberOfLine = Integer.parseInt(br.readLine());

        while(numberOfLine-- > 0){
            var st = new StringTokenizer(br.readLine());
            var command = st.nextToken();
          
            if("push_back".equals(command)){
                deque.offerLast(Integer.parseInt(st.nextToken()));
                continue;
            }

            if("push_front".equals(command)){
                deque.offerFirst(Integer.parseInt(st.nextToken()));
                continue;
            }
          

            var result = switch(command){
                case "pop_front" -> deque.isEmpty() ? -1 : deque.pollFirst();
                case "pop_back" -> deque.isEmpty() ? -1 : deque.pollLast();
                case "size" -> deque.size();
                case "empty" -> deque.isEmpty() ? 1 : 0;
                case "front" -> deque.isEmpty() ? -1 : deque.peekFirst();
                case "back" ->  deque.isEmpty() ? -1 : deque.peekLast();
                default -> throw new IllegalArgumentException();
            };

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
