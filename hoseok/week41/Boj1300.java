/*
    naive하게 풀려면, n * n번의 반복을 통해 모든 숫자를 구하고 -> 정렬하고, k번째 수를 반환하면 됨
    n은 최대 10^5이므로 배열의 크기가 최대 10^10, 시간 및 공간복잡도가 허락하지 않음

    B[k]의 = x -> x보다 작거나 같은 숫자가 적어도 k개가 존재한다는 의미 -> 이 x값을 찾아야 함
    x보다 작거나 같은 수를 구하기 위해선
    1 ~ N행까지 돌면서(i)
    x / i의 값을 카운팅 합니다. -> i의 배수를 이용해 작거나 같은 값만 더해짐
    
    이렇게 구한 값을 count라고 둘 때
    count의 값과 k값의 비교를 통해 low, high값을 조정해야 합니다.
    count값과 동일한 B[K]의 값이 여러개가 존재할 수 있지만, 만족하는 첫번째 값만 찾으면 되므로
    lower_bound 개념을 통해 첫번째 숫자를 확실하게 반환하면 됩니다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long l = 1;
        long r = (long) Math.pow(n, 2) + 1;
        while (l < r) {
            long mid = (l + r) / 2;

            long count = 0;
            for (long i = 1L; i <= n; i++) {
                count += Math.min(n, mid / i);
            }

            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        bw.write(l + "");
        bw.flush();
        bw.close();
    }
}
