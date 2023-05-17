import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String... args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());

        var tree = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<Integer>());
        }
        while (n-- > 1) {
            var st = new StringTokenizer(br.readLine());
            var parent = Integer.parseInt(st.nextToken());
            var child = Integer.parseInt(st.nextToken());

            tree.get(parent).add(child);
            tree.get(child).add(parent);
        }

        var q = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();

        while (q-- > 0) {
            var st = new StringTokenizer(br.readLine());
            var t = Integer.parseInt(st.nextToken());
            var k = Integer.parseInt(st.nextToken());

            if (t == 1) {
                if (tree.get(k).size() > 1) {
                    sb.append("yes\n");
                    continue;
                }
                sb.append("no\n");
                continue;
            }
            sb.append("yes\n");
        }

        System.out.print(sb);

    }
}
