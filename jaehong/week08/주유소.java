import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13035 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        var distance = new long[N + 1];
        var store = new long[N];

        var st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            store[i] = Long.parseLong(st.nextToken());
        }

        var result = 0L;
        var min = store[0];

        for (int i = 0; i < N - 1; i++) {
            min = Math.min(store[i], min);
            result += min * distance[i + 1];
        }
        System.out.println(result);
    }
}
