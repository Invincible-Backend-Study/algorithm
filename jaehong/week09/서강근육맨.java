import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@FunctionalInterface
interface Calculate {
    long execute();

}

public class Boj20300 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var arr = new long[N];
        var st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        Calculate oddCase = () -> {
            var max = 0L;
            // n이 6인 경우
            for (int i = 0; i < N / 2; i++) {
                max = Math.max(max, arr[i] + arr[N - i - 1]);
            }
            return max;
        };

        Calculate evenCase = () -> {
            // n이 홀수 인 경우
            // caseMax1 max2를 분리하는 이유는
            // 1 2 3 4 100000 같이 맨 끝의 값이 앞에 값보다 훨씬 큰 경우를 대비하기 위해 사용
            var caseMax1 = 0L;
            var caseMax2 = 0L;
            for (int i = 0; i < (N - 1) / 2; i++) {
                caseMax1 = Math.max(caseMax1, arr[i] + arr[N - i - 1]);
                caseMax2 = Math.max(caseMax2, arr[i] + arr[N - i - 2]);
            }
            caseMax2 = Math.max(caseMax2, arr[N - 1]);
            return Math.min(caseMax1, caseMax2);
        };

        if (N % 2 == 0) {
            System.out.println(oddCase.execute());
            return;
        }
        System.out.println(evenCase.execute());

    }
}
