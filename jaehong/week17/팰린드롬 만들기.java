
import java.io.*;
import java.util.*;


public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		final var n = Integer.parseInt( br.readLine());
		final var cache = new int[n+1][n+1];
		final var arr = new int[n+1];

		var st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n;i++){
			Arrays.fill(cache[i], -1);
			arr[i] = Integer.parseInt(st.nextToken());
		}


		Search search = (self,left, right) -> {
			if(left >= right) return 0;
			if(cache[left][right] != -1) return cache[left][right];
			var min = 0;

			if(arr[left] == arr[right]){
				return cache[left][right] = self.apply(self, left + 1, right -1);
			}
			return cache[left][right] = 1 + Math.min(self.apply(self, left +1, right), self.apply(self,left,right-1));
		};

		System.out.println(search.apply(search, 0, n-1));
	}
}

@FunctionalInterface
interface Search{
	int apply(Search search, int left, int right);
}
