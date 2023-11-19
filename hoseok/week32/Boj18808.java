import java.io.*;
import java.util.*;

class Main {

    private static int n, m, k;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            appendSticker(0, sticker);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    public static void appendSticker(int count, int[][] sticker) {
        if (count == 4) {
            return;
        }
        boolean isAppend = false;
        for (int i = 0; i < n; i++) {
            if (isAppend) {
                break;
            }
            for (int j = 0; j < m; j++) {
                if (canAppend(i, j, sticker)) {
                    append(i, j, sticker);
                    isAppend = true;
                    break;
                }
            }
        }
        if (!isAppend) {
            appendSticker(count + 1, turnToClockWay(sticker));
        }
    }

    public static boolean canAppend(int r, int c, int[][] sticker) {
        for (int i = r; i < r + sticker.length; i++) {
            for (int j = c; j < c + sticker[0].length; j++) {
                if (i >= n || j >= m) {
                    return false;
                }
                if (sticker[i - r][j - c] == 1 && map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void append(int r, int c, int[][] sticker) {
        for (int i = r; i < r + sticker.length; i++) {
            for (int j = c; j < c + sticker[0].length; j++) {
                if (sticker[i - r][j - c] == 1) {
                    map[i][j] = sticker[i - r][j - c];
                }
            }
        }
    }

    public static int[][] turnToClockWay(int[][] sticker) {
        int[][] newSticker = new int[sticker[0].length][sticker.length];

        for (int i = 0; i < newSticker.length; i++) {
            for (int j = 0; j < newSticker[0].length; j++) {
                newSticker[i][j] = sticker[newSticker[0].length - 1 - j][i];
            }
        }
        return newSticker;
    }
}
