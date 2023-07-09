import java.io.*; 
import java.util.*;

public class Boj2156{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N  = Integer.parseInt(br.readLine());
		var arr = new int[Math.max(4,N+1)];
		var cache = new int[Math.max(3,N+1)];

		for(int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		

		cache[1] = arr[1];
		cache[2] = cache[1] + arr[2];

		for(int i = 3; i <= N; i++){
			cache[i] = cache[i-3] + arr[i-1] + arr[i];
			cache[i] = Math.max(cache[i], cache[i-2] + arr[i]);
			cache[i] = Math.max(cache[i], cache[i-1]);
		}

		System.out.println(cache[N]);
	}
}
