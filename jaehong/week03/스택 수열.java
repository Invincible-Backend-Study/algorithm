/*
 *  n -> 수열의 개수
 *  이후 입력값
 *  43687521
 *
 *  4
 *  ++++-
 *  3
 *  -
 *  6
 *  ++-
 *  8
 *  ++-
 *  --
 *
 *  입력 값받은 n값이 나올때까지 push
 *
 * 첫 번째 시도 실패(70%)
 * 두 번째 시도 성공
 */

import java.util.*;
import java.io.*;
public class Boj1874 {

    public static void main(String...args)throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var stack = new Stack<Integer>();

        var countOfSequence= Integer.parseInt(br.readLine());
        var cache = new boolean[countOfSequence+1]; //빠져나간 숫자를 저장

        var index = 0;
        while(countOfSequence-- > 0){
            var element = Integer.parseInt(br.readLine()); // 요구하는 숫자
            if(cache[element]){
                System.out.println("NO");
                return;
            }
            // 비어 있는 스택의 경우
            var peek = stack.isEmpty() ? 0 : stack.peek();
            // 스택의 끝이 가르키는 숫자가 element 보다 작은 경우
            if(peek < element){
                for(int i = peek+1; i<=element;i++){
                    if(!cache[i]){
                        stack.push(i);
                        sb.append("+\n");
                    }
                }
                // 올바른 스택 구조가 아닌 경우
                if(stack.isEmpty()){
                    System.out.println("NO");
                    return ;
                }
                cache[element] = true;
                stack.pop();
                sb.append("-\n");
                continue;
            }


            // 스택의 끝이 가르키는 숫자가 element 보다 큰 경우 
            for (int i = peek; i >= element; i--) {
                if (!cache[i]) {
                    cache[i] = true;
                    stack.pop();
                    sb.append("-\n");
                }
            }
        }

        System.out.print(sb.toString());
    }
}
