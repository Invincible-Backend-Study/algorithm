import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int[] arr;
	static long[][] cache;
	static boolean[] visited;
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		var st = new StringTokenizer(br.readLine());
		arr = new int[N];
		cache = new long[100][21];

		for(int i = 0; i < 100; i++){
			Arrays.fill(cache[i], -1L);
		}

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 시작 지점을 더한 상태에서 출발
		var answer = search(1, arr[0]);
		System.out.println(answer);
	}

	static long search(int start, int sum){
		
		// 0~20 사이의 숫자만 유효하기 때문에 그렇지 않는 경우 무시합니다.
		if(sum < 0 || sum > 20) return 0;


		// 시작 지점에서 마지막으로 도달한 경우
		if(start == N-1){
			// 총합이 마지막 값과 동일한 경우
			return sum == arr[N-1]? 1 : 0;
		}

			// cache hit 
		if(cache[start][sum] != -1){
			return cache[start][sum ];
		}

		var answer = 0L;
		answer +=search(start+1, sum + arr[start]);
		answer +=search(start+1, sum - arr[start]); 
		return cache[start][sum ] = answer;

	}
}
