import java.io.*;
import java.util.*;

public class Boj11055{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N  = Integer.parseInt(br.readLine());
		var st = new StringTokenizer(br.readLine());
		var A  = new int[N];
		var cache = new int[N];
		
		for(int i = 0; i < N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}

		cache[0] = A[0];
		var answer = 0;

		for(int i = 0; i < N; i++){
			var max = 0;
			for(int j = 0; j < i; j++){
				if(A[i] > A[j]){
					max = Math.max(cache[j],max);
				}
			}
			cache[i] = max + A[i];
			answer = Math.max(cache[i], answer);
		}

		System.out.println(answer);	
	}
}
