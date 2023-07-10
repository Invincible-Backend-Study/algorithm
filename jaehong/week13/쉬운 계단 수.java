import java.io.*;
import java.util.*;
import java.awt.*;

public class Boj10844{
	private static HashMap<Point, Long> cache;
	private static long MOD = 1_000_000_000L;
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N  = Integer.parseInt(br.readLine());
		if(N == 1) {
			System.out.println(9);
			return ; 
		}
		cache = new HashMap<Point, Long>();
		cache.put(new Point(0, 2), 1L);
		cache.put(new Point(9, 2), 1L);
		for(int i = 1; i <= 8;i++){
			cache.put(new Point(i, 2),2L);
		}

		var answer = 0L;
		for(int i = 1; i <= 9; i++){
			answer += dfs(i,N);
		}
		System.out.println(answer % MOD);
	}
	static long dfs(int digit, int count){
		if(digit < 0 || digit > 9){
			return 0;
		}
		var point = new Point(digit, count);
		if(cache.containsKey(point)){
			return cache.get(point);
		}
		
		var sum =  dfs(digit-1, count -1) % MOD  + dfs(digit + 1, count -1) % MOD;
		cache.put(point, sum);
		return sum;
	}
}


