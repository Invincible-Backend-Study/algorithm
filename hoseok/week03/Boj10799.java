/*
    ( 괄호를 만나면 스택에 해당 괄호를 삽입한다.
    ) 괄호를 만나면 두 가지 동작으로 나뉜다.
        1. 직전 방문 괄호가 ( 라면 레이저를 쏜것 -> 기존 스택에 들어있던 괄호를 pop하고 남아있는 개수를 전체 합에 더해준다.
        2. 직전 방문 괄호가 ) 라면 하나의 막대기가 끝난것 -> pop을 하고 1을 전체합에 더해준다.

    잘못된 괄호가 주어지지 않으므로, 스택을 굳이 이용하지 않고 카운팅을 이용해도 될듯?
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String brackets = br.readLine();

        int totalCount = 0;

        char preBracket = ' ';
        int count = 0;
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(') {
                count++;
            } else {
                if (preBracket == '(') {
                    count--;
                    totalCount += count;
                } else {
                    totalCount++;
                    count--;
                }
            }
            preBracket = bracket;
        }

        bw.write(totalCount + "");
        bw.flush();
        bw.close();
    }
}
