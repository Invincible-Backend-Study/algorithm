/*
    진짜 raw한 풀이..
    
    2 * (2 + 3) -> 2 * 2 + 2 * 3과 동일 (곱셈의 분산법칙)
    (())[] -> 2 * 2 + 3
    
    1. (, [와 같이 열린 괄호를 만나면 현재 값에 괄호에 해당하는 값들을 곱해간다.
    2. 닫힌 괄호를 만나면, 직전에 방문한 괄호에 따라 동작이 나뉜다.
        2-1. 직전 괄호가 (, [ 와 같이 열린괄호라면 현재 값을 전체 합에 더하고, 닫힌 괄호에 해당하는 값을 현재 값에서 나눈다.
        2-2. 직전 괄호가 ), ]와 같이 닫힌 괄호라면 현재 값에서 닫힌 괄호에 해당하는 값을 나누기만 한다.
        
    반례, 엣지 케이스
    괄호의 길이는 최대 30이므로 나올 수 있는 최대의 수는 3^15임 -> int 타입으로 커버 가능
    아씌.. 잘못된 괄호열도 있음 -> 스택 이용 -> 문제 똑바로 읽자..
*/
import java.io.*;
import java.util.*;

class NavieSolving {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String brackets = br.readLine();

        Stack<Character> stack = new Stack<>();
        
        boolean isWrong = false;
        char preBracket = ' ';
        int totalSum = 0;
        int currentSum = 1;

        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(') {
                stack.push(bracket);
                currentSum *= 2;
            } else if (bracket == '[') {
                stack.push(bracket);
                currentSum *= 3;
            } else if (bracket == ')') {
                if (stack.isEmpty() || stack.peek() == '[') {
                    isWrong = true;
                    break;
                } else if (preBracket == '(') {
                    totalSum += currentSum;
                    currentSum /= 2;
                } else {
                    currentSum /= 2;
                }
                stack.pop();
            } else if (bracket == ']') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    isWrong = true;
                    break;
                } else if (preBracket == '[') {
                    totalSum += currentSum;
                    currentSum /= 3;
                } else {
                    currentSum /= 3;
                }
                stack.pop();
            }
            preBracket = bracket;
        }
        if (isWrong || !stack.isEmpty()) {
            bw.write("0");
        } else {
            bw.write(totalSum + "");
        }
        bw.flush();
        bw.close();
    }
}



/*
    메소드를 활용해서 조금 더 가독성이 쉬운 코드
    
    곱셈 분배법칙

    [, (를 만나면 해당 숫자를 계속 곱한다.

    ), ]를 만났을때 직전 괄호가
    [, (라면 현재 수를 전체 합에 더하고, 괄호에 맞는 수를 나눈다.
    ], )라면 현재 수에서 괄호에 맞는 수를 나누기만 한다.
*/

import java.io.*;
import java.util.*;

class MethodSolving {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String brackets = br.readLine();
        int totalSum = 0;
        int currentNumber = 1;
        char preBracket = ' ';
        Stack<Character> stack = new Stack<>();

        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(' || bracket == '[') {
                stack.push(bracket);
                preBracket = bracket;
                int number = getNumber(bracket);
                currentNumber *= number;
            } else {
                if (stack.isEmpty() || !isRightBracket(stack.peek(), bracket)) {
                    bw.write("0");
                    bw.flush();
                    bw.close();
                    return;
                }
                if (preBracket == '[' || preBracket == '(') {
                    totalSum += currentNumber;
                    currentNumber /= getNumber(stack.peek());
                } else {
                    currentNumber /= getNumber(stack.peek());
                }
                stack.pop();
                preBracket = bracket;
            }
        }
        if (!stack.isEmpty()) {
            bw.write("0");
        } else {
            bw.write(totalSum + ""); 
        }
        bw.flush();
        bw.close();
    }

    public static int getNumber(char bracket) {
        if (bracket == '(') {
            return 2;
        }
        return 3;
    }

    public static boolean isRightBracket(char topBracket, char bracket) {
        if (bracket == ')') {
            return topBracket == '(';
        }
        return topBracket == '[';
    }
}
