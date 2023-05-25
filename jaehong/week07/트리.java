// 수정 예정
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4256 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var sb = new StringBuilder();
        var testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            var size = Integer.parseInt(br.readLine());
            var preorder = init(size, new StringTokenizer(br.readLine()));
            var inorder = init(size, new StringTokenizer(br.readLine()));

            sb.append(createTree(preorder, inorder, 0, 0, size));
        }
        System.out.print(sb);
    }

    static int[] init(int size, StringTokenizer st) {

        var arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return arr;

    }

    static String createTree(int[] preorder, int[] inorder, int root, int start, int end) {
        var sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (inorder[i] == preorder[root]) {
                sb.append(createTree(preorder, inorder, root + 1, start, i));
                sb.append(createTree(preorder, inorder, root + i + 1 - start, i + 1, end));
                sb.append(preorder[root] + " ");
            }
        }
        return sb.toString();
    }
}

