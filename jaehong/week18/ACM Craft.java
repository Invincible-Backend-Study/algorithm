// 22분 56초
import java.io.*;
import java.util.*;

public class Boj1005{
	public static void main(String...args) throws Exception{
		final var br = new BufferedReader(new InputStreamReader(System.in));
		
		var T = Integer.parseInt(br.readLine());
		var sb = new StringBuilder();

		while(T-- > 0){
			var st = new StringTokenizer(br.readLine());

			final var N = Integer.parseInt(st.nextToken());
			final var K = Integer.parseInt(st.nextToken());

			final var arr = new int[N+1];

			final var tree = new ArrayList<ArrayList<Integer>>();
			final var cache = new long[N+1];

			Arrays.fill(cache, -1L);

			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i <= N; i++){
				tree.add(new ArrayList<Integer>());
			}

			for(int i = 0; i < K; i++){
				st = new StringTokenizer(br.readLine());
				final var X = Integer.parseInt(st.nextToken());
				final var Y = Integer.parseInt(st.nextToken());

				tree.get(Y).add(X);
			}

			var root = Integer.parseInt(br.readLine());
			Dfs dfs = (self, n) -> {
				if(n == 0) return 0;
				if(cache[n] != -1) return cache[n];

				var max= 0L;
				for(var node: tree.get(n)){
					max = Math.max(max, self.apply(self,node));
				}
				return cache[n] = max + arr[n];
			};

			sb.append(dfs.apply(dfs, root)).append("\n");
		}

		System.out.print(sb);
	}
}

@FunctionalInterface
interface Dfs{
	long apply(Dfs dfs, int n );
}
