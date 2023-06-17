import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        var arr = new int[N + 1];
        var sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i - 1];
        }
        var answer = 0;
        for (int i = 2; i < N; i++) {
            answer = Math.max(answer, sum[N] - arr[1] - arr[i] + sum[N] - sum[i]);
            answer = Math.max(answer, sum[N] - arr[N] - arr[i] + sum[i - 1]);
            answer = Math.max(answer, sum[i] - arr[1] + sum[N] - sum[i - 1] - arr[N]);
        }

        System.out.println(answer);

    }
}
