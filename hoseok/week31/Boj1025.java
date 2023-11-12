import java.io.*;
import java.util.*;

class Main {

    private static int n, m;
    private static int max = -1;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = -n; k <= n; k++) {
                    for (int l = -m; l <= m; l++) {
                        // 제자리에 맴도므로
                        if (k == 0 && l == 0) {
                            continue;
                        }
                        int nextR = i;
                        int nextC = j;
                        StringBuilder number = new StringBuilder();
                        while (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {
                            number.append(map[nextR][nextC]);
                            nextR += k;
                            nextC += l;

                            int curNumber = Integer.parseInt(number.toString());
                            if (isPerfectSquareNumber(curNumber)) {
                                max = Math.max(max, curNumber);
                            }
                        }
                    }
                }
            }
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static boolean isPerfectSquareNumber(int number) {
        int sqrtNumber = (int) Math.sqrt(number);
        return sqrtNumber * sqrtNumber == number;
    }
}
