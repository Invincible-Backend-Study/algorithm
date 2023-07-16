import java.io.*;
import java.util.*;

public class Main{
	static int n;
	static int[] arr;
	static int[] cache;
	public static void main(String...args) throws Exception{
		final var br = new BufferedReader(new InputStreamReader(System.in));
		final var st = new StringTokenizer(br.readLine());

		n  = Integer.parseInt(st.nextToken());
		final var k  = Integer.parseInt(st.nextToken());

		arr = new int[n+1];
		cache = new int[k+1];
		for(int i = 1; i <= n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 1; i <= n;i++){
			for(int j = arr[i]; j <= k; j++){
				if(j == arr[i]){
					cache[j] = cache[j] +1;
				}else{
					cache[j] = cache[j] + cache[j - arr[i]];
				} 
			}
		}

		System.out.println(cache[k]);
	}
}
