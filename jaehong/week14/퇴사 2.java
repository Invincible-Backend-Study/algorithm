import java.io.*;
import java.util.*;

public class Boj15486{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());
	
		var t = new int[N+2];
		var p = new int[N+2];
		var cache = new int[N+2];

		for(int i = 1; i <= N; i++){
			var st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}


		var answer = 0;
		for(int i =1; i<=N+1; i++){
			answer = Math.max(cache[i],answer);
			if(i + t[i] <= N+1){
				cache[i + t[i]] = Math.max(answer + p[i], cache[i + t[i]]); 
			}
		}
		System.out.println(answer);
	}
}
