import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17073 {

    public static void main(String... args) throws Exception {
        // N 노드의 수 W 물의 양

        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        var N = Integer.parseInt(st.nextToken());
        var W = Integer.parseInt(st.nextToken());

        var tree = new int[N + 1];

        int repeatCount = N;
        while (repeatCount-- > 1) {
            var inputSt = new StringTokenizer(br.readLine());

            var U = Integer.parseInt(inputSt.nextToken());
            var V = Integer.parseInt(inputSt.nextToken());

            tree[U]++;
            tree[V]++;
        }

        var count = 0;
        for (int i = 2; i <= N; i++) {
            if (tree[i] == 1) {
                count++;
            }
        }
        System.out.printf("%.10f\n", W * 1.0 / count);
    }
}
