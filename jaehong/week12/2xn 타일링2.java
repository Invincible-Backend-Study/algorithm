import java.io.*;
import java.util.*;

public class Boj11727{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());

		var size = Math.max(2,n) + 1;
		var cache = new int[size];


		cache[1] = 1;
		cache[2] = 3;

		for(int i = 3; i <= n; i++){
			cache[i] = (cache[i-2] * 2 + cache[i-1]) % 10_007;
		}
		System.out.println(cache[n]);
		
		
	}
}
