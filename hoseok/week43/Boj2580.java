import java.io.*;
import java.util.*;

class Main {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0);
    }

    public static void search(int r, int c) throws IOException {
        if (c == 9) {
            c = 0;
            r++;
        }
        if (r == 9) {
            // 끝
            print();
            System.exit(0);
        }

        if (map[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(r, c, i)) {
                    map[r][c] = i;
                    search(r, c + 1);
                    map[r][c] = 0;
                }
            }
        } else {
            search(r, c + 1);
        }
    }

    public static boolean isPossible(int r, int c, int value) {
        // 3 * 3사각형 검사
        int row = r / 3 * 3;
        int col = c / 3 * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == value) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (map[i][c] == value) {
                return false;
            }
        }
        return true;
    }

    public static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result.append(map[i][j]).append(" ");
            }
            result.append("\n");
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
