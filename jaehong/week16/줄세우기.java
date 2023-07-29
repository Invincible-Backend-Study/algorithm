import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		final var br = new BufferedReader(new InputStreamReader(System.in));
		final var N = Integer.parseInt(br.readLine());
		final var arr = new int[N];
		final var cache = new int[N];

		for(int i = 0; i < N;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.fill(cache, 1);

		var max = 0;
		for(int i = 1; i < N; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					cache[i] = Math.max(cache[i], cache[j] + 1);
				}
			}
			max = Math.max(max, cache[i]);
		}
		System.out.println(N - max);
	}
}
