import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        var X = new int[N][2];
        var allDistance = 0L;
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            X[i][0] = Integer.parseInt(st.nextToken());
            X[i][1] = Integer.parseInt(st.nextToken());
            allDistance += X[i][1];
        }

        Arrays.sort(X, (a1, a2) -> a1[0] - a2[0]);

        var target = allDistance % 2 == 0 ? allDistance / 2 : (allDistance + 1) / 2;
        for (int i = 0; i < N; i++) {
            if (X[i][1] >= target) {
                System.out.println(X[i][0]);
                return;
            }
            target -= X[i][1];
        }
    }
}
