import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11399 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        var arr = new int[n];

        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        var sum = 0;
        var waiting = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] + waiting;
            waiting += arr[i];
        }
        System.out.println(sum);
    }
}
