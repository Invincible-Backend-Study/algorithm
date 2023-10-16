import java.io.*;
import java.util.*;

class Main {

    private static int[] rows = {-1, -1, -1, 0, 1, 1, 1, 0, 0};
    private static int[] cols = {-1, 0, 1, 1, 1, 0, -1, -1, 0};

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static char[][] map;
    private static int[][] numberMap;
    private static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new char[8][8];
        numberMap = new int[8][8];

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int result = 0;
        numberMap[7][0] = 1;
        while (true) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (numberMap[i][j] == 1) {
                        que.offer(new Node(i, j));
                    }
                }
            }
            bfs();
            moveWall();

            boolean canMoveMore = false;
            for (int i = 0; i < 8; i++) {
                if (canMoveMore) {
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    if (numberMap[i][j] == 1) {
                        canMoveMore = true;
                        break;
                    }
                }
            }

            if (!canMoveMore) {
                break;
            }
            if (numberMap[0][7] == 1) {
                result = 1;
                break;
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            for (int j = 0; j < 9; j++) {
                int nextR = curNode.r + rows[j];
                int nextC = curNode.c + cols[j];

                if (nextR < 0 || nextR >= 8 || nextC < 0 || nextC >= 8) {
                    continue;
                }
                if (map[nextR][nextC] == '.') {
                    numberMap[nextR][nextC] = 1;
                }
            }
        }
    }

    public static void moveWall() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    if (i != 7) {
                        map[i + 1][j] = '#';
                        map[i][j] = '.';
                        numberMap[i + 1][j] = 0;
                    } else {
                        map[i][j] = '.';
                    }
                }
            }
        }
    }
}
