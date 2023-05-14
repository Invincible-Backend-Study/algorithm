import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj11725 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        var map = new HashMap<Integer, TreeSet<Integer>>();

        // init
        var testCase = Integer.parseInt(br.readLine());
        var size = testCase;

        for (int i = 1; i <= testCase; i++) {
            map.put(i, new TreeSet<Integer>());
        }

        while (testCase-- > 1) {
            var st = new StringTokenizer(br.readLine());

            var number1 = Integer.parseInt(st.nextToken());
            var number2 = Integer.parseInt(st.nextToken());

            map.get(number1).add(number2);
            map.get(number2).add(number1);
        }

        var parents = new int[size + 1];

        dfs(map, 1, parents);
        for (int i = 2; i <= size; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(HashMap<Integer, TreeSet<Integer>> map, int level, int[] parents) {
        for (var element : map.get(level)) {
            if (parents[element] == 0) {
                parents[element] = level;
                dfs(map, element, parents);
            }
        }
    }
}
