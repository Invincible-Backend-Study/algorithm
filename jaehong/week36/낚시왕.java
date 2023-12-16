import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - 낙시꾼 오른쪽으로 이동
 * - 상어 잡기
 *  - 현재 위치에서 가장 가까운 상어 잡기 (상어 사이즈 합계)
 * - 상어 이동
 *  - 상어는 각자 방향으로 정해진 만큼 이동
 *  - 만약 같은 칸에 있는 경우 상어의 크기가 큰 경우 잡아 먹음
 *
 * r x c 배열을 만들어야 하는가?
 *
 */
public class Boj17143 {

    static Shark[][] board; // 상어의 개수만 저장
    static int R;
    static int C;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    // board 초기화

    static void pPrint(){
        //Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
        //System.out.println("=");
    }
    public static void main(String...args) throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());

        R =  Integer.parseInt(st.nextToken());
        C =  Integer.parseInt(st.nextToken());
        var M =  Integer.parseInt(st.nextToken());
        var score = 0;
        board = new Shark[R][C];

        for(int i = 0; i < M; i++) new Shark(br.readLine());


        for(int n = 0; n < C; n++) {
            pPrint();
            for (int j = 0; j < R; j++) {
                if (board[j][n] != null) {
                    score += board[j][n].z;
                    board[j][n] = null;
                    break;
                }
            }


            var temp = new Shark[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == null)
                        continue;

                    var shark = board[i][j];
                    var speed = shark.s;

                    if (shark.d == 0 || shark.d == 2) speed %= (R - 1) * 2;
                    else if (shark.d == 1 || shark.d == 3) speed %= (C - 1) * 2;

                    for (int k = 0; k < speed; k++) {
                        int nr = shark.r + dx[shark.d];
                        int nc = shark.c + dy[shark.d];

                        if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                            shark.r -= dx[shark.d];
                            shark.c -= dy[shark.d];
                            shark.d = (shark.d + 2) % 4;
                            continue;
                        }
                        shark.r = nr;
                        shark.c = nc;
                    }


                    if (temp[shark.r][shark.c] != null) {
                        if (temp[shark.r][shark.c].z < shark.z) {
                            temp[shark.r][shark.c] = shark;
                        }
                    } else {
                        temp[shark.r][shark.c] = shark;
                    }
                }


            }

            board = temp;
        }
        System.out.println(score);


    }

    static class Shark {
        int r,c,s,d,z;

        public Shark(String input) {
            var st = new StringTokenizer(input);
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            if(d == 1) d = 0;
            else if(d == 4) d = 1;

            board[r][c] = this;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }


}
