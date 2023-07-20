import java.io.*;
import java.util.*;

public class Boj12865{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		var n = Integer.parseInt(st.nextToken());
		var k = Integer.parseInt(st.nextToken());


		var cache = new int[n+1][k+1];
		var arr = new int[n+1][2];

		for(int i = 1; i <= n; i++){
			st = new StringTokenizer(br.readLine());
			var w = Integer.parseInt(st.nextToken());
			var v = Integer.parseInt(st.nextToken());

			arr[i][0] = w;
			arr[i][1] = v;
		}


		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= k;j++){

				cache[i][j] = cache[i-1][j];
				if(j - arr[i][0] >= 0){ 
					cache[i][j] = Math.max(cache[i-1][j],
							cache[i-1][j - arr[i][0]] + arr[i][1]);
				}
			}
		}

		System.out.println(cache[n][k]);
	}
}
