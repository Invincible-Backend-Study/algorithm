import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var max = new StringBuilder();
        var min = new StringBuilder();
        var count = 0;

        var input = br.readLine();
        for (var element : input.toCharArray()) {
            if (element == 'K') {
                if (count == 0) {
                    max.append(5);
                    min.append(5);
                } else {
                    max.append(5).append("0".repeat(count));
                    min.append(1).append("0".repeat(count - 1)).append(5);
                }
                count = 0;
                continue;
            }
            count++;
        }

        if (count > 0) {
            max.append("1".repeat(count));
            min.append(1).append("0".repeat(count - 1));
        }

        System.out.println(max);
        System.out.println(min);
    }
}
