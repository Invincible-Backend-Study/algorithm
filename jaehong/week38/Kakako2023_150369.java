import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        var distance = 0L;

        var ds = create(n, deliveries);
        var ps = create(n, pickups);

        while(!ds.isEmpty() || !ps.isEmpty()){
            distance += Math.max(process(ds, cap), process(ps, cap)) * 2;
        }
        return distance;
    }
    int process(Stack<Block> ds, int cap){
        var maxPos = 0; 
        var tds = new Stack<Block>(); // temp
        while(cap > 0 && !ds.isEmpty()) {
            var block = ds.pop();
            maxPos = Math.max(maxPos, block.id);

            block.value -= cap;
            cap = block.value * -1;

            // 임시에 블록 추가
            if(block.value > 0) tds.push(block);
        }
        while(!tds.isEmpty()) ds.push(tds.pop());
        return maxPos;
    }
    Stack<Block> create(int n, int [] arr){
        var stack = new Stack<Block>();
        for(int i = 0; i < n; i++){
            if(arr[i] != 0) stack.push(new Block(i + 1, arr[i]));
        }
        return stack;

    }
}


class Block{
    int id; int value;
    Block(int id, int value){
        this.id = id;
        this.value = value;
    }
}
