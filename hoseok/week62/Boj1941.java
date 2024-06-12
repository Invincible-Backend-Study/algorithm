import java.io.*;
import java.util.*;

class Main {

    static final int[] rows = {-1, 1, 0, 0};
    static final int[] cols = {0, 0, 1, -1};

    static char[][] map = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        search(0, 0, 0, 0, 0, new int[7]);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static void search(int count, int r, int c, int yCount, int sCount, int[] out) {
        if (count == 7) {
            if (sCount < 4) {
                return;
            }
            if (isPossible(out)) {
                answer++;
            }
            return;
        }

        for (int i = r; i < 5; i++) {
            for (int j = c; j < 5; j++) {
                visited[i][j] = true;
                out[count] = i * 5 + j;
                if (map[i][j] == 'Y') {
                    search(count + 1, i, j + 1, yCount + 1, sCount, out);
                } else {
                    search(count + 1, i, j + 1, yCount, sCount + 1, out);
                }
                visited[i][j] = false;
            }
            c = 0;
        }
    }

    public static boolean isPossible(int[] out) {
        int r = out[0] / 5;
        int c = out[0] % 5;

        return dfs(r, c, new boolean[5][5]) == 7;
    }

    public static int dfs(int r, int c, boolean[][] check) {
        int count = 1;
        check[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nextR = r + rows[i];
            int nextC = c + cols[i];

            if (nextR < 0 || nextR >= 5 || nextC < 0 || nextC >= 5) {
                continue;
            }

            if (visited[nextR][nextC] && !check[nextR][nextC]) {
                count += dfs(nextR, nextC, check);
            }
        }
        return count;
    }
}
