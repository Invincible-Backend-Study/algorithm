/*
 * 첫 시도 메모리 초과
 */
import java.io.*;
import java.util.*;
public class Boj2346{

    public static void main(String...args) throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
      
        var ballonCount = Integer.parseInt(br.readLine());
        var deque = new ArrayDeque<Ballon>();
      
        var splitStr = br.readLine().split(" ");
        for(int i = 0 ; i < ballonCount; i++){
            var element = splitStr[i];
            deque.offerLast(new Ballon(i+1, Integer.parseInt(element)));
        }
      
        while(deque.size() > 1){
            var ballon = deque.pollFirst();
            System.out.print(ballon.startPosition + " ");
            //sb.append(ballon.startPosition).append(" ");
            if(ballon.moveCount < 0){
                while(ballon.moveCount++ < -1){
                    deque.offerFirst(deque.pollLast());
                }
                continue;
            }
            if(ballon.moveCount > 0){
                while(ballon.moveCount-- > 1){
                    deque.offerLast(deque.pollFirst());
                }
                continue;
            }
        }

        System.out.print(deque.pollFirst().startPosition);
        //sb.append(deque.pollFirst().startPosition);
        //System.out.print(sb);
    }
}

class Ballon{
    int moveCount;
    int startPosition;

    public Ballon(int startPosition, int moveCount){
        this.startPosition = startPosition;
        this.moveCount = moveCount;
    }

    @Override
    public String toString(){
        return String.format("moveCount:%d startPosition:%d", moveCount, startPosition);
    }
}

