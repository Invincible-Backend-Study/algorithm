import java.io.*;
import java.util.*;

public class Boj1823{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var arr = new int[N];
		var cache = new int[N][N];

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Dfs dfs = (self, start,end, k) -> {
			
			if(start == end) return arr[start] * k;

			if(cache[start][end] != 0) return cache[start][end];

			var max = self.apply(self, start+1, end, k + 1) + arr[start] * k;
			return cache[start][end]= max = Math.max(max, self.apply(self, start, end -1, k + 1) + arr[end] *k);
		}; 

		var result = dfs.apply(dfs, 0, N - 1, 1);
		System.out.println(result);
		
	}
}

@FunctionalInterface 
interface Dfs {
	int apply(Dfs self, int start, int end, int k);
}
