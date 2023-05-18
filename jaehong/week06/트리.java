import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1068 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var size = Integer.parseInt(br.readLine());

        var tree = new HashMap<Integer, ArrayList<Integer>>();

        var root = -1;

        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            var number = Integer.parseInt(st.nextToken());

            if (number == -1) {
                root = i;
            }

            var list = tree.getOrDefault(number, new ArrayList<Integer>());
            list.add(i);
            if (!tree.containsKey(number)) {
                tree.put(number, list);
            }
        }

        var ignoreNumber = Integer.parseInt(br.readLine());
        System.out.println(dfs(tree, root, ignoreNumber));
    }

    static int dfs(HashMap<Integer, ArrayList<Integer>> tree, int node, int ignoreNumber) {
        if (node == ignoreNumber) {
            return 0;
        }

        if (tree.containsKey(node)) {
            if (tree.size() == 1 && tree.get(node).get(0) == ignoreNumber) {
                return 1;
            }
        }
        if (!tree.containsKey(node)) {
            return 1;
        }

        var sum = 0;
        for (var element : tree.get(node)) {
            sum += dfs(tree, element, ignoreNumber);
        }
        return sum;
    }
}
