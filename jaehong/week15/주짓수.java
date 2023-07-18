import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		var N = Integer.parseInt(st.nextToken());
		var M = Integer.parseInt(st.nextToken());

		var map = new int[N+1][M+1];

		for(int i = 1; i <= N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; ++j){
				map[i][j] = Integer.parseInt(st.nextToken()) + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
			}
		}

		var K = Integer.parseInt(br.readLine());
		var sb = new StringBuilder();
		for(int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			var x1 = Integer.parseInt(st.nextToken());
			var y1 = Integer.parseInt(st.nextToken());
			var x2 = Integer.parseInt(st.nextToken());
			var y2 = Integer.parseInt(st.nextToken());

			sb.append(map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1])
				.append("\n");
		}

		System.out.println(sb);
	}
}
