import java.io.*;
import java.util.*;

public class Main {
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		final var N = Integer.parseInt(st.nextToken());
		final var M = Integer.parseInt(st.nextToken());
		final var H = Integer.parseInt(st.nextToken());

		final var students = new int[N][M+1];
		final var cache = new int[N][H+1];

		for(int i = 0; i < N; i++){
			Arrays.fill(cache[i], -1);

			st = new StringTokenizer(br.readLine());
			var count = 0;
			while(st.hasMoreTokens()){
				students[i][++count] = Integer.parseInt(st.nextToken());
			}
		}

		final Search func = (index, sum, self) -> {
			// H를 넘긴 경우
			if(sum > H){
				return 0;
			}
			if(index == N){
				return sum == H ? 1 : 0;
			}

			if(cache[index][sum] != -1){
				return cache[index][sum];
			}

			// 선택 안하는 경우
			var count = self.apply(index+1, sum, self);
			for(int i = 1; i <= M; i++){
				var value = students[index][i];
				if(value == 0){
					break;
				}
				count += self.apply(index+1, sum + value, self);
			}
			return cache[index][sum] = count % 10_007;
		};
		
		System.out.println(func.apply(0,0, func));
		
	}
}

@FunctionalInterface
interface Search{
	int apply(int index,  int sum, Search search);
}

