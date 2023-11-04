/*
    뒤집는 경우는 열방향 3개, 행방향 3개, 대각선 2개가 있다.
    결국 뒤집는 순서에 따라 중요하므로 순열이 된다.

    비트마스킹을 활용하면
    111 111 111 == 512가 되거나 혹은 0이 됐을때 탐색을 최소카운트를 갱신하고
    최소카운트를 구할 수 없다면 -1을 출력하면 됩니다.
*/
import java.io.*;
import java.util.*;

class Main {

    private static final int[] ANSWER = {511, 0};
    private static final int[] CHECK_BIT = {Integer.parseInt("100100100", 2),
                                            Integer.parseInt("010010010", 2),
                                            Integer.parseInt("001001001", 2),
                                            Integer.parseInt("111000000", 2),
                                            Integer.parseInt("000111000", 2),
                                            Integer.parseInt("000000111", 2),
                                            Integer.parseInt("100010001", 2),
                                            Integer.parseInt("001010100", 2)
                                           };
    private static boolean[] visited;
    private static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            minCount = Integer.MAX_VALUE;
            visited = new boolean[8];
            StringBuilder testCase = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    String value = st.nextToken();
                    if (value.equals("T")) {
                        testCase.append("1");
                    } else {
                        testCase.append("0");
                    }
                }
            }

            permutations(0, Integer.parseInt(testCase.toString(), 2));

            if (minCount == Integer.MAX_VALUE) {
                result.append("-1\n");
            } else {
                result.append(minCount).append("\n");
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void permutations(int count, int targetBit) {
        if (targetBit == ANSWER[0] || targetBit == ANSWER[1]) {
            minCount = Math.min(minCount, count);
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutations(count + 1, targetBit ^ CHECK_BIT[i]);
                visited[i] = false;
            }
        }
    }
}

