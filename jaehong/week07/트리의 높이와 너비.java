import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

@FunctionalInterface
interface Solution {
    void run(int root, int level);
}

public class Main {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());

        var node = new int[N + 1];
        var tree = new int[N + 1][2];

        var findRoot = new int[N + 1];
        var repeatCount = N;
        while (repeatCount-- > 0) {
            var st = new StringTokenizer(br.readLine());

            var root = Integer.parseInt(st.nextToken());
            var left = Integer.parseInt(st.nextToken());
            var right = Integer.parseInt(st.nextToken());

            tree[root][0] = left;
            tree[root][1] = right;

            findRoot[Math.max(left, 0)] = 1;
            findRoot[Math.max(right, 0)] = 1;
        }
        var rootNumber = findRootAction(findRoot, N);

        var min = new int[N + 1];
        var max = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            min[i] = N;
            max[i] = 0;
        }
        AtomicInteger count = new AtomicInteger(1);

        Solution solution = new Solution() {
            @Override
            public void run(int root, int level) {
                if (tree[root][0] != -1) {
                    run(tree[root][0], level + 1);
                }
                min[level] = Math.min(min[level], count.get());
                max[level] = Math.max(max[level], count.get());
                count.getAndIncrement();
                if (tree[root][1] != -1) {
                    run(tree[root][1], level + 1);
                }
            }
        };
        solution.run(rootNumber, 1);
        var answer = 0;
        var level = 1;
        for (int i = 1; i <= N; i++) {
            var result = max[i] - min[i] + 1;
            if (answer < result) {
                answer = result;
                level = i;
            }
        }
        System.out.printf("%d %d", level, answer);
    }

    static int findRootAction(int[] findRoot, int N) {
        for (int i = 1; i <= N; i++) {
            if (findRoot[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
