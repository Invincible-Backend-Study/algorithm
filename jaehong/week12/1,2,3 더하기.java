import java.io.*;
import java.util.*;

public class Boj9095{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var X = Integer.parseInt(br.readLine());
		var cache = new int[11];

		cache[1] = 1;
		cache[2] = 2;
		cache[3] = 4; 

		for(int i = 4; i < 11; i++){
			cache[i] = cache[i-3] + cache[i-2] + cache[i-1];
		}

	
		var sb = new StringBuilder();
		while(X-- > 0){
			var n = Integer.parseInt(br.readLine());
			sb.append(cache[n]).append("\n");
		}
		System.out.println(sb);
	}
}
