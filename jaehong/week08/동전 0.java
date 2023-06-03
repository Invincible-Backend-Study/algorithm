import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        var N = Integer.parseInt(st.nextToken());
        var K = Integer.parseInt(st.nextToken());

        var coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        var position = N - 1;
        var answer = 0;
        while (K > 0) {
            var coin = coins[position];
            if (K < coin) {
                position--;
                continue;
            }

            answer++;
            K -= coin;
        }
        System.out.println(answer);

    }
}
