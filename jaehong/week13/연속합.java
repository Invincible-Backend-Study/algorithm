import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N  = Integer.parseInt(br.readLine());
		var st = new StringTokenizer(br.readLine());
		
		var arr = new int[N+1];
		var cache = new int[N+1];

		for(int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		var answer = arr[1];
		cache[1] = arr[1];

		for(int i = 2; i <= N; i++){
			cache[i] = Math.max(cache[i-1] + arr[i], arr[i]);
			answer = Math.max(cache[i],  answer);
		}


		System.out.println(answer);
	}
}
