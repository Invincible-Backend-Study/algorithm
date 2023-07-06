import java.io.*;
import java.util.*;

public class Boj22857{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		var n = Integer.parseInt(st.nextToken());
		var k = Integer.parseInt(st.nextToken());

		var arr = new int[n];
		var cache = new int[n];

		st = new StringTokenizer(br.readLine());
		

		for(int i = 0; i <n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cache[0] = arr[0] % 2 == 0 ? 0 : 1;

		for(int i=1; i < n; i++){
			cache[i] = cache[i-1] + (arr[i] % 2 == 0 ? 0 : 1);
		}
		var answer = 0; 

		for(int i = 0; i < n; i ++){
			var ll = 0;
			var rl = i;

			while(ll <= rl){
				var mid = (ll + rl) / 2;
				var cnt = 0;
				
				if(mid == 0) cnt = cache[i];
				else cnt = cache[i] - cache[mid - 1];

				if(cnt <= k) rl = mid - 1;
				else ll = mid + 1;

			}
				var left = rl+1;
				if(left == 0) answer = Math.max(answer, i - left + 1 - cache[i]);
				else answer = Math.max(answer, i - left + 1 - (cache[i] - cache[rl]));
		}
		System.out.println(answer);
	}
}
