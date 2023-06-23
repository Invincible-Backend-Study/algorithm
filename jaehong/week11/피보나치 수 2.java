import java.io.*;
import java.util.*;

public class Boj2748{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());

		var cache = new long[Math.max(n,1) + 1];

		cache[0] = 0;
		cache[1] = 1;
		for(int i =2; i <= n; i++){
			cache[i] = cache[i-2] + cache[i-1];
		}
		System.out.println(cache[n]);
	}
}
