import java.io.*;
import java.util.*;

class Main {

    // 우, 우상, 우하, 하
    private static final int[] rows = {0, -1, 1, 1};
    private static final int[] cols = {1, 1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] map = new int[21][21];

        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 검1 흰2 승부 없다면 0
        for (int r = 1; r <= 19; r++) {
            for (int c = 1; c <= 19; c++) {
                if (map[r][c] != 0) {
                    for (int i = 0; i < 4; i++) {

                        int count = 1;
                        int nextR = r;
                        int nextC = c;
                        for (int j = 0; j < 5; j++) {
                            nextR += rows[i];
                            nextC += cols[i];

                            if (nextR > 19 || nextC > 19 || nextR < 1 || nextC < 1) {
                                break;
                            }
                            if (map[nextR][nextC] == map[r][c]) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        if (count == 5) {
                            if (map[r - rows[i]][c - cols[i]] != map[r][c]) {
                                bw.write(map[r][c] + "\n" + r + " " + c);
                                bw.flush();
                                bw.close();
                                return;
                            }
                        }
                    }
                }
            }
        }

        bw.write("0");
        bw.flush();
        bw.close();
    }
}
