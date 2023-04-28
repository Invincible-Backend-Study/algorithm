/*
 *
 * (()[[]])([])
 *
 * (
 * ((
 * (2
 * (2[[
 * (2[3
 * (29
 * (2,9)
 * 4 + 18
 *
 * [2,9] -> numbers
 * ()
 *
 * ( -> -1
 * [ -> -2 로 정의
 * 음수가 나올 수 없는 환경으로 판단
 */

// 1차 시도 실패 (50%)
// 2차 시도 실패 (82%)
// 3차 시도 성공
//

import java.util.*;
import java.io.*;


public class Boj2504{

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String...args)throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine();

        for(var element: input.toCharArray()){

            if(element == '(') {
                stack.push(-1);
                continue;
            }
            if(element == '['){
                stack.push(-2);
                continue;
            }

            var result = switch(element){
                case ')' -> processExpression(-1, -2, 2);
                case ']' -> processExpression(-2, -1, 3);
                default -> 0;
            };
            // 결과가 0인경우 유효하지 않은 값으로 판단
            if(result == 0){
                System.out.println(result);
                return ;
            }

            stack.push(result); // 계산 결과를 저장
        }

        var answer = 0;
        while(!stack.isEmpty()){
            var element =  stack.pop();
            // 정산 과정에서 -1, -2 와 같은 열린 괄호가 존재하는 경우 잘못된 문자열로 판단
            if(element.equals(-1) || element.equals(-2)){
                answer = 0;
                break;
            }
            answer += element;
        }
        System.out.println(answer);

    }

    private static int processExpression(int validBracket, int invalidBracket, int bracketValue){
        var result = 0;
        var invalidPairFlag = true; // 비정상적인 괄호를 감지
        while(!stack.isEmpty()){
            var lastElement = stack.pop();
            // 비정상적인 괄호를 감지함
            if(lastElement.equals(invalidBracket)){
                break;
            }
            if(lastElement.equals(validBracket)){
                invalidPairFlag = false; // 정상적인 괄호 쌍을 찾은 경우

                if(result == 0){
                    result = 1; // 바로 열고 닫히는 경우
                }
                result *= bracketValue;
                break;
            }
            result += lastElement;
        }

        return invalidPairFlag ? 0 : result; // 유효하지 않은 표현식인 경우 0을 리턴함
    }

}
