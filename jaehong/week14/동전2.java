import java.io.*;
import java.util.*;

public class Boj2294{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		var n  = Integer.parseInt(st.nextToken());
		var k  = Integer.parseInt(st.nextToken());

		var arr   = new int[n];
		var cache = new int[k+1];

		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.fill(cache, Integer.MAX_VALUE - 1);
		cache[0] = 0;

		for(int i = 0; i < n; i++){
			for(int j = arr[i]; j <= k; j++){
				cache[j] = Math.min(cache[j], cache[j - arr[i]] + 1);
			}
		}
		System.out.println(cache[k] == Integer.MAX_VALUE  - 1? -1: cache[k]);

		
	}
}
