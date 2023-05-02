import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1620 {

    public static void main(String... args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        var st = new StringTokenizer(br.readLine());

        var numberOfTestCases = Integer.parseInt(st.nextToken());
        var count = Integer.parseInt(st.nextToken());

        var map = new HashMap<String, String>();

        for (int i = 0; i < numberOfTestCases; i++) {
            var name = br.readLine();

            map.put(String.valueOf(i + 1), name);
            map.put(name, String.valueOf(i + 1));
        }

        for (int i = 0; i < count; i++) {
            var key = br.readLine();
            sb.append(map.get(key)).append("\n");
        }

        System.out.print(sb);

    }
}

