/*
 * () -> -
 * (())
 *
 * ( -> 다음 원소가 ( 경우 막대기
 * ( -> 다음 원소가 ( 경우 레이저
 * ) -> 막대기 하나 빼기
 */
import java.io.*;
import java.util.*;

public class Boj10799{
    public static void main(String...args) throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var answer = 0;
        var count = 0; // 막대기 개수

        var baskets = br.readLine().toCharArray();
        var size = baskets.length;

        for(int i = 0; i < size; i++){
            var element = baskets[i];

            if(element == '('){
                // 올바른 입력이 들어온다는 것을 전제로 함
                var nextElement = baskets[i+1];
                // 다음 괄호가 여는 괄호는 막대기
                if(nextElement == '('){
                    count++;
                    continue;
                }
                // 닫는 괄호인 경우 레이저 [()]
                answer += count;
                i++;
                continue;
            }
            if(element == ')'){
                count--;
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}

