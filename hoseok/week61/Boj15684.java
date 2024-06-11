import java.io.*;
import java.util.*;

class Main {

    static int n, m, h;
    static boolean[][] ladder;
    static boolean isPossible;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        ladder = new boolean[h][n];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            ladder[a][b] = true;
        }

        int answer = -1;
        for (int i = 0; i <= 3; i++) {
            search(0, 0, i);
            if (isPossible) {
                answer = i;
                break;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static void search(int r, int c, int count) {
        if (count == 0) {
            if (canClimb()) {
                isPossible = true;
            }
            return;
        }

        for (int i = r; i < h; i++) {
            for (int j = c; j < n - 1; j++) {
                if (!ladder[i][j] && canSetLadder(i, j)) {
                    ladder[i][j] = true;
                    search(i, j + 1, count - 1);
                    ladder[i][j] = false;
                }
            }
            c = 0;
        }
    }

    public static boolean canSetLadder(int r, int c) {
        if (c == 0) {
            return !ladder[r][c + 1];
        } else if (c == n - 2) {
            return !ladder[r][c - 1];
        }
        return !ladder[r][c + 1] && !ladder[r][c - 1];
    }

    public static boolean canClimb() {
        for (int i = 0; i < n; i++) {
            if (climb(i) != i) {
                return false;
            }
        }
        return true;
    }

    public static int climb(int c) {
        for (int i = 0; i < h; i++) {
            if (ladder[i][c]) {
                c++;
            } else if (c > 0 && ladder[i][c - 1]) {
                c--;
            }
        }
        return c;
    }
}
