import java.io.*; 
import java.util.*;

public class Boj2758{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var T = Integer.parseInt(br.readLine());

		var sb = new StringBuilder();
		while(T-- > 0){
			var st = new StringTokenizer(br.readLine());
			var N = Integer.parseInt(st.nextToken());
			var M = Integer.parseInt(st.nextToken());
			sb.append(solve(N,M)).append("\n");
		}
		System.out.print(sb);
	}

	static long solve(int N, int M){
		final var cache = new long[N+1][M+1];
		for(int i = 0; i <= N; i++){
			Arrays.fill(cache[i], -1);
		}
		for(int i = 1; i <= M; i++){
			cache[1][i] = i;
		}

		Search search = (self, x, y) -> {
			if(y <= 0) return 0;
			if(cache[x][y] != -1) return cache[x][y];

			// 1칸 빼거나 /2 하는 경우
			return cache[x][y] = (self.apply(self, x - 1, y / 2) + self.apply(self,x, y - 1));
		};
		return search.apply(search, N, M);
	}
}

@FunctionalInterface
interface Search{
	long apply(Search search, int N, int M);
}
