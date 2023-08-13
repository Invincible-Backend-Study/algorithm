import java.io.*;
import java.util.*;

public class Boj20181{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		var st = new StringTokenizer(br.readLine());

		var n = Integer.parseInt(st.nextToken());
		var k = Integer.parseInt(st.nextToken());

		var arr = new long[n+1];
		var cache = new long[n+1];
		var sum = 0L;
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++){
			arr[i] = Long.parseLong(st.nextToken());
		}

		for(int r = 1, l = 0; r<=n; r++){
			sum += arr[r];
			cache[r] = cache[r-1]; 

			while(sum >= k){
				cache[r] = Math.max(cache[r], cache[l] + sum - k);
				sum -= arr[++l];
			}
		}

		System.out.println(cache[n]);
	}
}
