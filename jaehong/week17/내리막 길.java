import java.io.*;
import java.util.*;

public class Boj1520{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		final var M = Integer.parseInt(st.nextToken());
		final var N = Integer.parseInt(st.nextToken());
		final var board = new int[M][N]; 

		final var direction = new int[][]{
			{-1, 0}, {0, -1}, {1, 0}, {0, 1}
		};

		final var cache = new int[M][N];
		final var FINISHED = 1;
		final var FAILED = 0;
		final var NOT_GOAING = -1;



		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine()); 

			for(int j = 0; j < N; j++){
				cache[i][j] = NOT_GOAING;
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		Run run = (self, x, y) -> { 
			if(x == M - 1  && y == N - 1){
				return FINISHED;
			}
			if(cache[x][y] != -1){
				return cache[x][y];
			}


			var count = FAILED;
			for(int i = 0; i < 4; i++){
				var nx= x + direction[i][0];
				var ny = y + direction[i][1];

				if(nx < 0 || nx == M) continue;
				if(ny < 0 || ny == N) continue;
				if(board[x][y] <= board[nx][ny]) continue; 

				count += self.apply(self, nx,ny);
			}
			return cache[x][y] = count;
		};
		System.out.println(run.apply(run, 0, 0));
	}
}

@FunctionalInterface
interface Run{
	int apply(Run run, int x, int y);
}
