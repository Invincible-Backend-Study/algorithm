import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj14916 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        var min = N;
        var count = 1;

        for (int i = 0; i * 5 <= N; i++) {
            var n = N - i * 5;

            if (n % 2 == 0) {
                min = Math.min(min, n / 2 + i);
            }
        }

        if (min == N) {
            min = -1;
        }
        System.out.println(min);

    }
}
