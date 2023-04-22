/*

	처음 라인은 케이스
	두번째는 표현식 -> 스택으로 처리 예정
	세번째는 숫자 -> 순서대로 해시에 저장할 예정

*/
import java.util.*;
import java.io.*;
public class Boj1935{

    public static void main(String...args) throws Exception{
      
        var br = new BufferedReader(new InputStreamReader(System.in));
      
        var valueTable = new LinkedHashMap<Character,Double>();
        var stack = new Stack<Double>();
      
        var numberOfLine = Integer.parseInt(br.readLine());
        var expression = br.readLine();
      
        for(int i = 0 ; i < numberOfLine; i++){
            Character key = (char)(65 + i);
            valueTable.put(key, Double.parseDouble(br.readLine()));
        }
      
        for(var element: expression.toCharArray()){
            // 연산자가 아닌 경우
            if(valueTable.containsKey(element)){
                stack.add(valueTable.get(element));
                continue;
            }
          
            var last = stack.pop();
            var first = stack.pop();
          
            var result = switch(element){
                case '+' -> first + last;
                case '-' -> first - last;
                case '*' -> first * last;
                case '/' -> first / last;
                default -> throw new IllegalArgumentException(); // 존재하지 않는 연산자.
            };
            stack.push(result);
        }
        System.out.printf("%.2f\n", stack.pop());
    }
}
