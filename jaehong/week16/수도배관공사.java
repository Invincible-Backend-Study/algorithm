import java.io.*;
import java.util.*;

public class Boj2073{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine()); 

		final var D = Integer.parseInt(st.nextToken());
		final var P = Integer.parseInt(st.nextToken()); 

		final var arr = new int[P][2]; 

		for(int i = 0; i < P; i++){
			st = new StringTokenizer(br.readLine());

			var L = Integer.parseInt(st.nextToken());
			var C = Integer.parseInt(st.nextToken());

			arr[i][0] = L;
			arr[i][1] = C;
		}
		var cache = new int[D+1];


		cache[0] = Integer.MAX_VALUE;

		for(int i = 0; i < P; i++){
			for(int j = D; j >= arr[i][0]; j--){
				cache[j] = Math.max(cache[j], Math.min(cache[j - arr[i][0]], arr[i][1]));
			}
		}

		System.out.println(cache[D]);
	}
}
