import java.io.*;
import java.util.*;

public class Boj21941{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		final var S = br.readLine();
		final var M = Integer.parseInt(br.readLine()); 

		final var A = new String[M];
		final var X = new int[M][2];

		final var end = S.length();
		final var cache = new int[end];

		for(int i = 0; i < M; i++){
			var st = new StringTokenizer(br.readLine());

			A[i] = st.nextToken();
			X[i][0] = Integer.parseInt( st.nextToken());
			X[i][1] = A[i].length();
		}
		

		Run run = (self, x) -> {
			if(x >= end){
				return 0;
			}

			if(cache[x] != 0){
				return cache[x];
			}
			// 넘어갈 수 있는 범위를 허용하는 길이
			var acceptRange = end - x;
			
			var max = 0;
			for(int i = 0; i < M; i++){
				var size = X[i][1];

				if(acceptRange < size){
					continue; 
				}
				var str = S.substring(x,x + size);
				if(str.equals(A[i])){
					max = Math.max(max,self.apply(self, x + size) + X[i][0]);
				}
			}
			return cache[x] = Math.max(max, self.apply(self, x + 1) + 1);
		}; 

		var result = run.apply(run, 0);

		System.out.println(result);
	}
}


@FunctionalInterface
interface Run{
	int apply(Run run, int x);
}
