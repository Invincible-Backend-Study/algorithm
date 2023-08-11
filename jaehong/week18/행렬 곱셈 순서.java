import java.io.*;
import java.util.*;

public class Boj11049{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());


		final var arr = new int[n+1];
		final var cache = new int[n][n];

		for(int i = 0; i < n; i++){

			var st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i+1] = Integer.parseInt(st.nextToken());
		}


		for(int i = 0; i < n; i++){
			Arrays.fill(cache[i], Integer.MAX_VALUE);
		}

		Dfs dfs = (self, pos, now) ->{
			if(pos == now) return 0;
			if(cache[pos][now] != Integer.MAX_VALUE) return cache[pos][now];

			for(int i = pos; i < now; i++){
				var value = self.apply(self, pos, i)
					+ self.apply(self, i+1, now)
					+ (arr[pos] * arr[i+1] * arr[now+1]);
				cache[pos][now] = Math.min(cache[pos][now], value);
			}
			return cache[pos][now];
		};

		System.out.println(dfs.apply(dfs, 0, n -1));
		
	}
}

@FunctionalInterface 
interface Dfs{
	int apply(Dfs dfs, int pos, int now);
}
