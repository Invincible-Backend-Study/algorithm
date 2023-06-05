import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20115 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        var max = 0;
        var sum = 0;
        for (int i = 0; i < N; i++) {
            var element = Integer.parseInt(st.nextToken());
            max = Math.max(element, max);
            sum += element;
        }
        // (max + a1/2) + a2/2  + a3/2 + a4/2 + a5/2
        //
        // 10 + 2 / 2 + 3 / 2 + 9 / 2 + 6 / 2
        // 10 + 1 + 1.5 + 4.5 + 3;
        // 20
        var result = (sum + max) / 2;
        System.out.printf("%.5f\n", result);
    }
}
