import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{ 
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		
		final var NOT_GOING = Integer.MIN_VALUE;
		final var N = Integer.parseInt(st.nextToken());
		final var M = Integer.parseInt(st.nextToken());
		final var arr = new int[N][M];
		final var cache = new int[N+1][M+1][2];
		final var move = new int[][][]{ 
			{{0,1},{-1,0}},
			{{0,1},{ 1,0}}
		};

		for(int i = 0; i <= N; i++){
			for(int j = 0; j <= M; j++){
				Arrays.fill(cache[i][j], NOT_GOING);
			}
		}

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Run run = (self, x, y, direction) -> { 
			if(x == N - 1 && y == M - 1 && direction == 1){
				return arr[x][y];
			}

			if(cache[x][y][direction] != NOT_GOING){
				return cache[x][y][direction];
			}

			var max = cache[x][y][direction];
			if(direction == 0) {
				max = self.apply(self, x, y, direction + 1);
			}

			for(int d = 0; d < 2; d++){
				var nextX = x + move[direction][d][0];
				var nextY = y + move[direction][d][1];

				if(nextX < 0 || nextX >= N) continue;
				if(nextY < 0 || nextY >= M) continue;
				
				max = Math.max(max, self.apply(self,nextX, nextY, direction));
			}
			return cache[x][y][direction] = max + arr[x][y];
		};

		System.out.println(run.apply(run, N-1, 0,0));
		

	}
}

@FunctionalInterface
interface Run{
	int apply(Run run, int x, int y, int direction);
}
