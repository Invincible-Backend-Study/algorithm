import java.io.*;
import java.util.*;

public class Boj9465{

	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var sb = new StringBuilder();
		var T = Integer.parseInt(br.readLine());

		while(T-- > 0){
			var N = Integer.parseInt(br.readLine());
			var arr = new int[2][N+1];
			var cache = new int[2][N+1];

			var st1 = new StringTokenizer(br.readLine());
			var st2 = new StringTokenizer(br.readLine());

			for(int i = 1; i <= N;i++){
				arr[0][i] = Integer.parseInt(st1.nextToken());
				arr[1][i] = Integer.parseInt(st2.nextToken());
			}

			cache[0][1] = arr[0][1];
			cache[1][1] = arr[1][1];

			for(int i = 2; i <= N; i++){
				var max = Math.max(cache[0][i-2], cache[1][i-2]);
				cache[0][i] = arr[0][i] + Math.max(max, cache[1][i-1]);
				cache[1][i] = arr[1][i] + Math.max(max, cache[0][i-1]);
			}
			sb.append(Math.max(cache[0][N], cache[1][N])).append("\n");
		}
		System.out.print(sb);
	}
}
