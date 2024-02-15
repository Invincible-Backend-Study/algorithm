import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        var stackD = createStack(deliveries);
        var stackP = createStack(pickups);

        while(!stackD.isEmpty() || !stackP.isEmpty()){
            var distance = 0L;
           
            if(!stackD.isEmpty()) distance = Math.max(distance, stackD.peek().index);
            if(!stackP.isEmpty()) distance = Math.max(distance, stackP.peek().index);
            
            process(cap, stackD);
            process(cap, stackP);
            answer += distance * 2;
        }

        return answer;
    }
    void process(int cap, Stack<Pair> stack){
        while(cap > 0 && !stack.isEmpty()){
            var pair = stack.pop();
            cap = cap - pair.item;
            if(cap >= 0) continue;
            pair.item = cap * -1;
            stack.push(pair);
        }
    }

    Stack<Pair> createStack(int[] arr){
        var stack = new Stack<Pair>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) continue;
            stack.push(new Pair(i, arr[i]));
        }
        return stack; 
    }
}

class Pair{
    int index;
    int item;

    Pair(int index, int item){
        this.index = index + 1;
        this.item = item;
    }
}

/*

n개의 집에 택배 배달

모두 크기가 같은 -> 가중치와 같은 제한은 없음

배달 + 수거 두 행위가 존재함

물류창고에서 i번쨰 집까지의 이동거리는 i만큼 떨어져 있음 

트럭에 재활용 택배 상자를 cap만큼 실을 수 있는데 출발하면서 배달 복귀하면서 수거가 가능함 

최소 이동 거리를 구해야 함

마지막에서 출발한 다음 택배를 배달/수거함

여기서 고려해야 할 것은 만약 최대 배달량을 넘어서는 개수만큼 배달/수거해야 하는 경우임

*/
