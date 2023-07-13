import java.io.*;
import java.util.*;

public class Boj22869{
	static int[] arr;
	static boolean[][] cache;
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		var  N = Integer.parseInt(st.nextToken());
		var  K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		cache = new boolean[N][N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		var result = dfs(N-1, K);
		System.out.println(result ? "YES" : "NO");
	}

	static boolean dfs(int N, int K){
		if(N == 0) {
			return true;
		}
		for(int i = N-1; i>= 0; i--){
			if(cache[N][i]){ // 실패한 경로
				return false;
			}
			var value = (N - i) * (1 + Math.abs(arr[i] - arr[N]));

			if(value > K){
				cache[N][i] = true; //실패한 경로 설정
				continue;
			}

			if(dfs(i, K)){
				return true;
			}
		}
		return false;
	}
}
