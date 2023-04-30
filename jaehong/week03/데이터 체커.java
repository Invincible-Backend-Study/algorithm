import java.util.*;
import java.io.*;

// 우선 순위 큐로 하는 것이 효율이 안좋은가? 
// 특정 자료구조를 사용하지 않아도 상관없지 않았을까? 
// 효율이 좋은것 같지 않음
// 첫 시도 20 % 실패
// 성공
public class Boj22942{

    public static void main(String...args)throws Exception{

        var br = new BufferedReader(new InputStreamReader(System.in));
        // 굳이 우선순위 큐를 사용해야 할까?
        var queue = new PriorityQueue<Coordinate>();

        var countOfTestCase = Integer.parseInt(br.readLine());

        // 중복된 위치값이 저장되는 것을 막음
        var previousPositionValueStore = new HashSet<Integer>();

        while(countOfTestCase-- > 0){
            var inputs = br.readLine().split(" ");
            // 원의 중심
            var x = Integer.parseInt(inputs[0]);
            var value = Integer.parseInt(inputs[1]);

            // 중복된 위치값을 검증
            if(previousPositionValueStore .contains(x + value) || previousPositionValueStore.contains(x-value)){
                System.out.println("NO");
                return ;
            }
            previousPositionValueStore.add(x + value);
            previousPositionValueStore.add(x - value);
            queue.offer(new Coordinate(x, x + value));
            queue.offer(new Coordinate(x, x - value));
        }

        var stack = new Stack<Coordinate>();

        while(!queue.isEmpty()){
            var Coordinate = queue.poll();

            if(stack.isEmpty()){
                stack.push(Coordinate);
                continue;
            }

            var stackElement = stack.peek();
            // 원의 중심을 비교해서 동일한 원의 중심인 경우 스택에서 제거
            if(stackElement.center.equals(Coordinate.center)){
                stack.pop();
                continue;
            }
            stack.push(Coordinate);
        }

        System.out.println(stack.isEmpty() ? "YES" : "NO");
    }
}

class Coordinate implements Comparable<Coordinate>{

    Integer center;
    Integer position;

    public Coordinate(Integer center, Integer position){
        this.center = center;
        this.position= position;
    }

    public int compareTo(Coordinate coordinate){
        return position.compareTo(coordinate.position);
    }
    @Override
    public String toString(){
        return String.format("{ center: %d, position: %d}", center, position);
    }
}
