import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

@FunctionalInterface
interface Solution {
    void createTree(int istart, int iend, int pstart, int pend);
}

public class Main {
    public static void main(String... args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var inorder = init(N, new StringTokenizer(br.readLine()));
        var postorder = init(N, new StringTokenizer(br.readLine()));
        var preorder = new int[N];

        var sb = new StringBuilder();
        var index = new AtomicInteger();

        Solution solution = new Solution() {
            @Override
            public void createTree(int istart, int iend, int pstart, int pend) {
                if (istart <= iend && pstart <= pend) {
                    preorder[index.getAndIncrement()] = postorder[pend];
                    var pos = istart;

                    for (int i = istart; i <= iend; i++) {
                        if (inorder[i] == postorder[pend]) {
                            pos = i;
                            break;
                        }
                    }
                    createTree(istart, pos - 1, pstart, pstart + pos - istart - 1);
                    createTree(pos + 1, iend, pstart + pos - istart, pend - 1);
                }
            }
        };
        solution.createTree(0, N - 1, 0, N - 1);

        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (var element : preorder) {
            bw.write(element + " ");
        }
        bw.flush();
    }

    static int[] init(int size, StringTokenizer st) {
        var arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}
