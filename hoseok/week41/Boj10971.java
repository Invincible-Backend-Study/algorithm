import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 어떤 도시에서 시작해도 순회 특성상 반드시 해당 도시는 지나가기에 상관없음
        boolean[] visited = new boolean[n];
        visited[0] = true;
        // 시작 지점, 현재 지점, 합, 카운트, 방문처리
        travelSalesman(0, 0, 0, 1, visited);

        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    public static void travelSalesman(int start, int cur, int sum, int count, boolean[] visited) {
        if (count == n) {
            // N번째 도시까지 방문을 완료했다면, N번째 도시에서 처음 도시로 다시 방문할 수 있는지 체크후 최소값 갱신
            if (map[cur][start] > 0) {
                min = Math.min(min, sum + map[cur][start]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (map[cur][i] > 0 && !visited[i]) {
                visited[i] = true;
                travelSalesman(start, i, sum + map[cur][i], count + 1, visited);
                visited[i] = false;
            }
        }
    }
}
