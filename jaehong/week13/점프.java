import java.io.*;
import java.util.*;
import java.awt.*;

public class Boj1890{
	static int count = 0;
	static Map<Point, Long> cache;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N  = Integer.parseInt(br.readLine()); 
		arr = new int[N][N];
		cache = new HashMap<Point,Long>();
		visited = new boolean[N][N];

		for(int i = 0; i < N; i++){
			var st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(search(0, 0, N));

	}


	public static long search(int y, int x, int N){
		if(N <= y || N <=  x){
			return 0;
		}

		var point = new Point(x,y);

		if(cache.getOrDefault(point, 0L) != 0L){
			return cache.get(point);
		}

		if(N == y+1 && N == x + 1){
			return 1;
		}

		if(visited[y][x]){
			return 0;
		}
		visited[y][x] = true;


		 

		var move = arr[y][x];
		

		var count = search(y + move, x, N) + search(y, x + move, N);
		cache.put(point, count);
		return count;
	}
}
