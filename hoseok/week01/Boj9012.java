/*
    풀이 1: 비어있는 스택 별도의 플래그로 구별
    
    YES가 나올 수 있는 상황
    괄호 문자열에 맞게 연산을 모두 완료했을 경우 스택이 비어있어야 함

    NO가 나올 수 있는 상황
    연산 완료후 스택에 괄호가 남아있거나
    ')'를 만났을때 스택이 비어있다면 NO
*/
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreaReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        while (n-- > 0) {
            String brackets = br.readLine();
            int bracketCount = 0;
            for (char bracket : brackets.toCharArray()) {
                if (bracket == '(') {
                    bracketCount++;
                } else {
                    if (bracketCount == 0) {
                        result.append("NO\n");
                        bracketCount = -1;
                        break;
                    } else {
                        bracketCount--;
                    }
                }
            }
            if (bracketCount != -1 && bracketCount == 0) {
                result.append("YES\n");
            } else if (bracketCount >= 1) {
                result.append("NO\n");
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
/*
    풀이2 메소드로 분리해 비어있는 스택 별도로 구별하지 않아도 됨
    
    )를 만났을때 스택이 비어있다면 NO를 출력해야 하지만
    하나의 괄호에 대해 모든 연산이 종료된 후 스택이 비어있다면 YES이다.
    위 둘의 구분이 필요한데 이떄 return값을 이용하면 쉽게 해결할 수 있음
*/

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (n-- > 0) {
            String brackets = br.readLine();
            result.append(solve(brackets));
        }
    }

    public static String solve(String brackets) {
        int count = 0;
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(') {
                count++;
            } else {
                if (count == 0) {
                    return "NO\n";
                } else {
                    count--;
                }
            }
        }
        if (count == 0) {
            return "YES\n";
        }
        return "NO\n";
    }
}
