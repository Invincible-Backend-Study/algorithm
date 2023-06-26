import java.io.*;
import java.util.*;

public class Boj17626{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());
		var cache = new int[N+1];

		cache[1] = 1;

		for(int i = 2; i <= N; i++){
			int min = 4; // 법칙에 따라 최소 4개의 개수만을 가짐
			for(int j = 1; j * j <= i; j++){
				int temp = i - j * j;
				min = Math.min(min, cache[temp]);;
			}
			cache[i] = min + 1;
		}

		System.out.println(cache[N]);
	}
} 
	 
