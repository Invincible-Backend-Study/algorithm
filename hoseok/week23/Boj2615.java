import java.io.*;
import java.util.*;

class Main {
    private static int[] row = {0, 1, -1, 1}; // 우, 우하, 우상 하
    private static int[] col = {1, 1, 1, 0};

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

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int count = 1;
                    int nextR = i;
                    int nextC = j;
                    for (int l = 0; l < 5; l++) {
                        nextR += row[k];
                        nextC += col[k];

                        if (nextR > 20 || nextR < 1 || nextC > 20 || nextC < 1) {
                            break;
                        }
                        if (map[nextR][nextC] == map[i][j]) {
                            count++;
                        } else {
                            break;
                        }
                    }

                    if (count == 5) {
                        nextR = i - row[k];
                        nextC = j - col[k];
                        
                        if (map[nextR][nextC] == map[i][j]) {
                            continue;
                        }
                        bw.write(map[i][j] + "\n" + i + " " + j);
                        bw.flush();
                        bw.close();
                        return;
                    }
                }
            }
        }
        bw.write("0");
        bw.flush();
        bw.close();
        return;
    }
}
