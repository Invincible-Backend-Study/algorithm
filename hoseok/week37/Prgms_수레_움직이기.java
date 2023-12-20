class Solution {

    static final int[] rows = {-1, 1, 0, 0};
    static final int[] cols = {0, 0, -1, 1};

    private static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    private static final int INF = Integer.MAX_VALUE;

    private boolean[][][] visited;
    private boolean redEnd, blueEnd;
    private int[][] map;

    public int solution(int[][] maze) {
        this.map = maze;
        visited = new boolean[map.length][map[0].length][2];

        Node red = null;
        Node blue = null;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    red = new Node(i, j);
                } else if (map[i][j] == 2) {
                    blue = new Node(i, j);
                }
            }
        }
        visited[red.r][red.c][0] = true;
        visited[blue.r][blue.c][1] = true;
        int solve = solve(red, blue, 0);
        if (solve == INF) {
            return 0;
        }
        return solve;
    }

    public int solve(Node red, Node blue, int count) {
        if (redEnd && blueEnd) {
            return count;
        }
        int answer = INF;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Node nRed;
                Node nBlue;
                if (redEnd) {
                    nRed = new Node(red.r, red.c);
                } else {
                    nRed = new Node(red.r + rows[i], red.c + cols[i]);
                }
                if (blueEnd) {
                    nBlue = new Node(blue.r, blue.c);
                } else {
                    nBlue = new Node(blue.r + rows[j], blue.c + cols[j]);
                }

                // 기본조건
                if (isInvalid(nRed) || isInvalid(nBlue) || map[nRed.r][nRed.c] == 5 || map[nBlue.r][nBlue.c] == 5) {
                    continue;
                }
                if ((nRed.r == blue.r && nRed.c == blue.c) && (nBlue.r == red.r && nBlue.c == red.c)) {
                    continue;
                }
                if ((!redEnd && visited[nRed.r][nRed.c][0]) || (!blueEnd && visited[nBlue.r][nBlue.c][1])) {
                    continue;
                }
                if (nRed.r == nBlue.r && nRed.c == nBlue.c) {
                    continue;
                }
                if (map[nRed.r][nRed.c] == 3) {
                    redEnd = true;
                }
                if (map[nBlue.r][nBlue.c] == 4) {
                    blueEnd = true;
                }

                visited[nRed.r][nRed.c][0] = true;
                visited[nBlue.r][nBlue.c][1] = true;
                answer = Math.min(solve(nRed, nBlue, count + 1), answer);
                visited[nRed.r][nRed.c][0] = false;
                visited[nBlue.r][nBlue.c][1] = false;
                redEnd = false;
                blueEnd = false;

            }
        }
        return answer;
    }
    
    private boolean isPossible(Node cntRed, Node red,
                               Node cntBlue, Node blue){
        // 기본 탐색 규칙
        if(red.r < 0 || red.c < 0 || red.r >= map.length || red.c >= map[0].length
                || blue.r < 0 || blue.c < 0 || blue.r >= map.length || blue.c >= map[0].length
                || map[red.r][red.c] == 5 || map[blue.r][blue.c] == 5) return false;

        // 두 수레 스위치 체크
        if((cntRed.r == blue.r && cntRed.c == blue.c)
                && (cntBlue.r == red.r && cntBlue.c == red.c)) return false;

        // 도착지점에 도착하지도 않고 중복방문이라면 false
        if((!redEnd && visited[red.r][red.c][0])
                || (!blueEnd && visited[blue.r][blue.c][1])) return false;

        // 두 수레가 동일한 지점에 위치시
        if(red.r == blue.r && red.c == blue.c) return false;
        return true;
    }

    public boolean isInvalid(Node node) {
        return node.r < 0 || node.r >= map.length || node.c < 0 || node.c >= map[0].length;
    }
}
