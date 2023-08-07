import java.io.*;
import java.util.*;

public class Boj2228 { 
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		var st = new StringTokenizer(br.readLine());

		final var N = Integer.parseInt(st.nextToken());
		final var M = Integer.parseInt(st.nextToken());

		final var arr = new int[N+1];
		final var cache = new int[N+1][N/2 + 1];

		final var MIN = -3276800;
		for(int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(br.readLine());

			for(int j = 1; j <= N / 2; j++){
				cache[i][j] = -1;
			}
		}


		Run run = (self, n, m) ->{
			if(m == 0) return 0; 
			if(n <= 0) return MIN;
			if(cache[n][m] != -1) return cache[n][m];

			var sum = 0; 

			cache[n][m] = self.apply(self, n - 1, m);

			for(int i = n; i > 0 ; i--){
				sum += arr[i];
				cache[n][m] =Math.max(self.apply(self, i - 2, m - 1) + sum, cache[n][m]);
			}

			return cache[n][m];
		};

		System.out.println(run.apply(run, N, M));
	}
}

@FunctionalInterface
interface Run{
	int apply(Run run, int n, int m);
}
