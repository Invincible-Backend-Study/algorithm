import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1758 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        var arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        var sum = 0L;

        for (int i = n; i >= 1; i--) {
            var result = arr[i] - (n - i);
            if (result <= 0) {
                break;
            }
            sum += result;
        }

        System.out.println(sum);

    }
}
