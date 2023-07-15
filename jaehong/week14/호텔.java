import java.io.*;
import java.util.*;

public class Boj1106{
	static int answer = Integer.MAX_VALUE;
	static int[][] city;
	static int[] cache;
	public static void main(String...args) throws Exception{
		final var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		final var C = Integer.parseInt(st.nextToken());
		final var N = Integer.parseInt(st.nextToken());

		// 0 -> 비용
		// 1 -> 고객 수
		city = new int[N][2];
		cache = new int[C+1];;

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			city[i][0] = Integer.parseInt(st.nextToken());
			city[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dfs(C));
	}

	static int dfs(int N){
		// 기저 사례
		if(N <=  0){
			return 0;
		}

		if(cache[N] != 0){
			return cache[N];
		}

		var min = Integer.MAX_VALUE;
		for(var element: city){
			var next = N - element[1];
			// 0 보다 작은 경우는 더 진행할 수 없다.
			min = Math.min(min, dfs(next) + element[0]);
		}
		if(min == Integer.MAX_VALUE){
			return 0;
		}
		return cache[N] = min;
	}
}
