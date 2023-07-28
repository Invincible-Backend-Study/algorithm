import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		final var N = Integer.parseInt(st.nextToken());
		final var M = Integer.parseInt(st.nextToken());
		final var arr = new int[N][M];
		final var cache = new int[N][M];

		for(int i = 0; i < N; i++){
			var line = br.readLine().toCharArray();
			for(int j = 0; j < M; j++){
				arr[i][j] = Character.getNumericValue(line[j]);
				cache[i][j] = -1;
			}
		}

		Search search = (n, m, self) -> {
			if(n < 0 || n >= N) return 0;
			if(m < 0 || m >= M) return 0;

			if(cache[n][m] != -1){
				return cache[n][m];
			}
			if(arr[n][m] == 0){
				return cache[n][m] = 0;
			}

			cache[n][m] = self.apply(n, m + 1, self);
			cache[n][m] = Math.min(cache[n][m],self.apply(n + 1, m, self));
			cache[n][m] = Math.min(cache[n][m],self.apply(n + 1 , m + 1, self));
			return cache[n][m] += 1;
		};

		var max = 0;
		 for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    max = Math.max(max, search.apply(i, j,search));
                }
            }
        }
		System.out.println(max * max);
		
	}
}

@FunctionalInterface
interface Search{
	int apply(int n, int m, Search search);
}
