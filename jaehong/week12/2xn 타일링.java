import java.io.*; 
import java.util.*;

public class Main{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());

		var cache = new int[1001];
		
		cache[1] = 1;
		cache[2] = 2;

		for(int i = 3; i <= 1000; i++){
			cache[i] = (cache[i-1] + cache[i-2]) % 10_007;
		}

		System.out.println(cache[n]);
	}
}
