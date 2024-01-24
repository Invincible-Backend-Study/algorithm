import java.io.*;
import java.util.*;

class Main {

    static final int[] rows = {0, -1, -1};
    static final int[] cols = {-1, -1, 0};
    static int n, m;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        play(map, 0, 0);

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    public static void play(int[][] map, int r, int c) {
        if (c == m) {
            r++;
            c = 0;
        }
        if (r == n) {
            count++;
            return;
        }
        if (shouldNotFill(map, r, c)) {
            play(map, r, c + 1);
            return;
        }
        
        map[r][c] = 1;
        play(map, r, c + 1);
        map[r][c] = 0;
        play(map, r, c + 1);
    }
    
    public static boolean shouldNotFill(int[][] map, int r, int c) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            int nextR = rows[i] + r;
            int nextC = cols[i] + c;
            
            if (nextR < 0 || nextC < 0) {
                continue;
            }
            if (map[nextR][nextC] == 1) {
                count++;
            }
        }
        return count == 3;
    }
}
