import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[][] stickers = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int r1 = stickers[i][0];
                int c1 = stickers[i][1];
                int r2 = stickers[j][0];
                int c2 = stickers[j][1];


                // a스티커를 붙일 수 있다면
                if (isPossible(r1, c1, h, w)) {
                    // b를 그대로 붙이거나 90도 돌려서 붙일 수 있다면 최대값 갱신 (그걸 세로로 붙임)
                    if (isPossible(r2, c2, h - r1, w) || isPossible(c2, r2, h - r1, w)) {
                        max = Math.max(max, r1 * c1 + r2 * c2);
                        // b를 가로로 붙이는데 그대로 붙이거나 90도 돌려서 붙이는게 가능하다면 최대값 갱신
                    } else if (isPossible(r2, c2, h, w - c1) || isPossible(c2, r2, h, w - c1)) {
                        max = Math.max(max, r1 * c1 + r2 * c2);
                    }
                }
                // a스티커를 90도 돌려서 붙일 수 있다면
                if (isPossible(c1, r1, h, w)) {
                    // b를 세로로 붙이는데 그대로 붙이거나 90도 돌려서 붙일 수 있을때
                    if (isPossible(r2, c2, h - c1, w) || isPossible(c2, r2, h - c1, w)) {
                        max = Math.max(max, r1 * c1 + r2 * c2);
                        // b를 가로로 붙이는데 그대로 붙이고나 90도 돌려서 붙일 수 있을때
                    } else if (isPossible(r2, c2, h, w - r1) || isPossible(c2, r2, h, w - r1)) {
                        max = Math.max(max, r1 * c1 + r2 * c2);
                    }
                }

            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    public static boolean isPossible(int a, int b, int h, int w) {
        return h >= a && w >= b;
    }
}
