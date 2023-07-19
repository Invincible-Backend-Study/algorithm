import java.io.*;
import java.util.*;

public class Boj9084{

	public static void main(String...args) throws Exception{

		var br = new BufferedReader(new InputStreamReader(System.in));
		var sb = new StringBuilder();

		var T = Integer.parseInt(br.readLine());

		while(T-- > 0){
			var N = Integer.parseInt(br.readLine());
			var st = new StringTokenizer(br.readLine());

			var arr = new int[N];
			for(int i = 0; i < N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			var M = Integer.parseInt(br.readLine());
			var cache = new int[M+1];
			cache[0] = 1;

			for(int i = 0; i < N;i ++){
				for(int j = arr[i]; j <= M; j++){
					cache[j] += cache[j - arr[i]];
				}
			}
			sb.append(cache[M]).append("\n");
		}
		System.out.print(sb);
	}

}
