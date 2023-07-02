import java.io.*;
import java.util.*;

public class Boj2579{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var arr = new int[N+1];
		var cache = new int[N+1];
	
		for(int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		cache[1] = arr[1];
		cache[2] = arr[2] + arr[1];


		for(int i = 3; i <= N; i++){
			cache[i] = arr[i-1] + cache[i-3];
			cache[i] = Math.max(cache[i-2], cache[i]) + arr[i];
		} 

		System.out.println(cache[N]);

		
	}
}
