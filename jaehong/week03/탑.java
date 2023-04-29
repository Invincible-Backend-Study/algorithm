
/**
 * 첫 시도 시간 초과}
 */
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Boj2493{

    static class Tower{
        int number; // 비교를 위한 값
        int index;
        public Tower(int number, int index){

            this.number= number;
            this.index = index;
        }

    }

    public static void main(String...args) throws Exception{

        var br = new BufferedReader(new InputStreamReader(System.in));
        var stack = new Stack<Tower>();

        var inputCase = Integer.parseInt(br.readLine());
        var input = br.readLine().split(" ");

        // 정답을 저장하기 위한 배열
        var answer = new int[inputCase];


        for(int i = 0 ; i < inputCase; i++){
            var element = new Tower(Integer.parseInt(input[i]), i);

            // 새로 추가되는 원소보다 작은 값은 존재할 필요가 없기때문에 제거
            while (!stack.empty() && stack.peek().number < element.number) {
                stack.pop();
            }

            // 스택이 비어있는 경우는 0으로 초기화 되어 있는 값을 그대로 사용함
            if(!stack.isEmpty()){
                // 스택의 마지막을 확인
                // 요구하는 인덱스는 0이 아닌 1부터 시작
                answer[i] = stack.peek().index +1;
            }
            stack.push(element);
        }

        var sb = new StringBuilder();
        for(var element: answer) {
            sb.append(element).append(" ");
        }

        System.out.println(sb);
    }
}
