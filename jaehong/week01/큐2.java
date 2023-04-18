
/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
import java.io.*;
import java.util.*;

public class Boj18258{

    public static void main(String...args) throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        var numberOfLine = Integer.parseInt(br.readLine());
        int lastInsertedValue = 0;
        while(numberOfLine-- > 0){

            var commandText = br.readLine().split(" ");
            var command = commandText[0];

            if("push".equals(command)){
                var value = Integer.parseInt(commandText[1]);
                queue.add(value);
                lastInsertedValue = value;
                continue;
            }
            var result = switch(command){
                case "pop" -> queue.isEmpty() ? -1 :queue.poll();
                case "size" -> queue.size();
                case "empty" -> queue.isEmpty() ? 1 : 0;
                case "front" -> queue.isEmpty() ? -1 : queue.peek();
                case "back" -> queue.isEmpty() ? -1 : lastInsertedValue;
                default -> throw new IllegalArgumentException();
            };

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

}
