public class p154539 {
    import java.util.*;
    class Solution {
        //https://school.programmers.co.kr/learn/courses/30/lessons/154539
        // 9 8 7 6 5 4 3 2 1 10 이 있다 가정하면 이중 for문으로는 10*10이어서 100의 시간이 걸리지만
        // stack으로 진행하면 10번의 시간복잡도로 해결이 가능하다 1까지는 모두 이전 보다 작기 때문에 계속 들어가고 10부터는 while문으로 끝내기가가능
        // 이문제에서 떠올릴 아이디어는 무엇이냐
        // 1. 내가 앞에 있는 번호보다 크다면 앞번호에 대한 정답을 구할 수 있다 즉 맨마지막 들어온값부터 확인하면 좋다
        // 2. 4 2 3으로 입력이 들어오는 경우에서 stack으로 구현한다면 2가 3덕분에 사라지니 4 3이 남게 되고 이후에 값에서는 2를 쓰지 않아도 된다.
    /*

    이 코드의 시간복잡도는 O(n)입니다.
    이유는 다음과 같습니다:

    numbers 배열을 처음부터 끝까지 한 번 순회하므로 기본적으로 O(n) 시간이 소요됩니다.
    내부의 while 루프가 있지만, 각 요소는 스택에 최대 한 번 들어가고 최대 한 번 나오게 됩니다.
    모든 push와 pop 연산을 고려해도 총 연산 횟수는 2n을 초과하지 않습니다.

    따라서 전체 시간복잡도는 O(n)입니다. 이 코드는 다음 큰 수(Next Greater Element)를 찾는 효율적인 알고리즘의 구현입니다.

    */


    /* 시간초과 코드
        List<Integer> list = new ArrayList<>();
        loop :
        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            for(int j = i+1; j < numbers.length; j++) {
                if(num < numbers[j]) {
                    answer[i] = numbers[j];
                    continue loop;
                }
            }
            answer[i] = -1;
        } */

        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<int[]> stack = new Stack<>();
            int[] initArr = {0,numbers[0]};
            stack.add(initArr);
            for(int i = 1; i < numbers.length; i++) {
                while(!stack.isEmpty()) {
                    int[] arr = stack.peek();
                    int index = arr[0];
                    int num = arr[1];
                    if(num < numbers[i]) {
                        answer[index] = numbers[i];
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.add(new int[]{i,numbers[i]});
            }
            while(!stack.isEmpty()) {
                int[] arr = stack.pop();
                int index = arr[0];
                answer[index] = -1;
            }


            return answer;
        }
    }
}
