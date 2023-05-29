import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1343 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var input = br.readLine() + ".";
        var answer = new StringBuilder();

        var count = 0;
        for (var element : input.toCharArray()) {
            if (element == '.') {
                while (count >= 4) {
                    if (count < 4) {
                        break;
                    }
                    count -= 4;
                    answer.append("AAAA");
                }
                while (count >= 2) {
                    count -= 2;
                    answer.append("BB");
                }

                if (count != 0) {
                    System.out.println(-1);
                    return;
                }
                answer.append(".");
                continue;
            }
            count++;
        }

        answer.deleteCharAt(answer.length() - 1);
        System.out.println(answer);
    }
}
