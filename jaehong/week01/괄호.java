// 시간: 29:32

// 괄호 문자열()로 구성되어 있음
// () -> vps
// ()() -> vps
// (()) -> vps

// 짝이 맞아야 하는건가?
// 일단 짝은 맞는데...

// (()()(
// 아 스택으로 하나씩 빼버리면 되겠네


import java.io.*;
import java.util.*;

public class Boj9012 {

    public static void main(String...args) throws Exception{

        var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        var line = Integer.parseInt(bufferedReader.readLine());
        var answer = new StringBuilder();
        while(line-- > 0){
            var input = bufferedReader.readLine();
            answer.append(new Solution().solve(input)).append("\n");
        }
        System.out.print(answer);
    }
}

class Solution{

    private Stack<String> stack = new Stack<>();

    public AnswerText solve(String input){
        // 어차피 같은 값만 안에 들어갈건데 굳이 String 을 써야할까?

        // split이랑 toCharArray어느게 더 좋은 방법
        // ) 이것도 넣어줘야 하네
        for(var bracket : input.split("")){
            switch(bracket){
                case "(" -> stack.add(bracket);
                case ")" -> this.remove();
            }
        }
        return stack.empty() ? AnswerText.YES : AnswerText.NO;
    }

    public void remove(){
        if(!stack.empty() && "(".equals(stack.peek())){
            stack.pop();
            return;
        }
        stack.push(")");
    }
}

enum AnswerText{
    YES,
    NO;
}
