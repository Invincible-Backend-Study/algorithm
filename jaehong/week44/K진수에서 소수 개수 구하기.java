import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n, int k) {
        return (int) Arrays.stream(Integer.toString(n, k).split("0"))
            .filter(s -> !s.isBlank())
            .map(Long::parseLong)
            .filter(this::isPrime)
            .count();
    }
    
    boolean isPrime(long n){
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if( n % i == 0) return false;
        }
        return true;
    
    }
}

/*

문제의 설명에서는 양의 정수 n이 주어집니다.
이 숫자를 k진수로 바꿨을 때 변환된 수 안에 아래 조건에 맞는 소수가 몇 개인지 알아보려 한다.

즉 자바에서 양의 정수 n -> k진수로 변환해야 함
k는 3 ~ 10의 범위로 제한 

진수로 변환하는 것은 Integer.toString() 메서드를 활용해서 n을 k진수로 변환할 수 있습니다.

다음은 k진수로 변환했을 때 이후의 문제인데

변환된 수 안에 조건에 맞는 소수를 찾는 것입니다.

현재 437674의 경우 3진수로 변환하면
211020101011 가 됩니다.

여기서 4가지 조건을 만족하도록 해야 하는데 
1. 0p0: 양쪽에 0이 있는 경우
2. P0 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
3. 0P 소수 양쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
4. P처럼 소수 양쪽에 아무것도 없는 경우

즉 조건을 보면 문자열에서 0을 기준으로 나눌 수 있습니다.

즉 211020101011에서 0을 기준으로 나누면
211 2 1 1 11

여기서 맨 처음과 끝을 제외하면 1번 조건을 만족한다. 처음은 2번 조건 마지막은 3번 조건을 만족하는데

4번 조건을 만족하는 경우는 변환된 진수에 0이 없는 경우를 예시로 들 수 있다.

즉 정리하면 0을 기준으로 나눠서 각 자리수에 있는 값의 소수를 구하면된다.

*/
