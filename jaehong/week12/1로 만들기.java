import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1로 만들기
 * <p> https://www.acmicpc.net/problem/1463 </p>
 * 문제 요약
 * <pre>
 * - X가 3으로 나누어 떨어지면 3으로 나눈다.
 * - X가 2로 나누어 떨어지면 2로 나눈다.
 * - 1을 뺀다.
 * </pre>
 * 연산의 최소 횟수를 구하라
 *
 * <pre>
 * 1은 연산을 하지 않음 -> 0
 * 2는 2,3번 연산을 통해서 1로 만들 수 있음
 * 3는 1번 연산을 통해서 1로 만들 수 있음. 하지만 1을 빼고 2로 만든 다음 2,3번 연산을 통해서 만들 수 있지만 1번 연산을 사용하는 것이 더 효율적임 ( operation1(3) < operation2(operation3(3)))
 * 4는 3번 연산 혹은 2번 연산을 통해서 2 혹은 3으로 만든 다음 1로 만들 수 있음
 * </pre>
 */
public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String... args) throws IOException {
        final var input = Integer.parseInt(bufferedReader.readLine());
        final var answer = new Solution();
        System.out.println(answer.solve(input));
    }

    public static class Solution {

        public int solve(final int input) {
            var cache = new int[(int) Math.pow(10, 6) + 1];
            Arrays.fill(cache, 0);

            cache[0] = 0;
            cache[1] = 0;
            cache[2] = 1;
            cache[3] = 1;
            cache[4] = 2;

            for (int i = 5; i <= input; i++) {
                int min = Integer.MAX_VALUE;
                if (i % 3 == 0) {
                    min = Math.min(min, cache[i / 3]);
                }
                if (i % 2 == 0) {
                    min = Math.min(min, cache[i / 2]);
                }
                min = Math.min(min, cache[i - 1]);
                cache[i] = min + 1;
            }

            return cache[input];
        }
    }
}
