import java.io.*;
import java.util.*;

public class Boj2579{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		
		var N = Integer.parseInt(br.readLine());
		var arr = new int[N + 1];

		var cache = new int[N+1][2];

		for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());


		// [n][0] = 전진 가능
		// [n][1] = 상시 두칸 전진
		// 3 ->
		

		cache[1][0] = arr[1];
		cache[1][1] = arr[1];

		for(int i = 2; i <= N; i++){
			cache[i][0] = Math.max(cache[i-2][0], cache[i-2][1]) + arr[i];
			cache[i][1] = cache[i-1][0] + arr[i];
		}

		System.out.println(Math.max(cache[N][0], cache[N][1]));


	}
}
