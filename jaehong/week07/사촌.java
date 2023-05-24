import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        while (true) {
            var input = br.readLine();
            if (input.charAt(0) == '0') {
                break;
            }
            var solution = new Solution();
            sb.append(solution.solve(input, br.readLine())).append("\n");
        }

        System.out.print(sb);
    }
}

class Solution {
    int solve(String firstLine, String secondLine) {
        var st = new StringTokenizer(firstLine);

        var n = Integer.parseInt(st.nextToken());
        var k = Integer.parseInt(st.nextToken());

        var tree = new int[n][2];
        var kIndex = 0;
        var pIndex = 0;
        var prev = -1;

        st = new StringTokenizer(secondLine);
        for (int i = 0; i < n; i++) {
            var input = Integer.parseInt(st.nextToken());
            if (input == k) {
                kIndex = i;
            }
            if (prev + 1 != input && i > 1) {
                pIndex++;
            }

            tree[i] = new int[]{input, i == 0 ? -1 : pIndex};
            prev = input;
        }

        var answer = 0;
        var kParentIndex = tree[kIndex][1];
        for (int i = 1; i < n; i++) {
            var value = tree[i][1];

            if (tree[kParentIndex][0] != tree[value][0]
                    && tree[kParentIndex][1] == tree[value][1]) {
                answer++;
            }
        }
        return answer;
    }
}

