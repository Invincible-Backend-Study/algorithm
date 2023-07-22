import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static long[][] cache;
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		var K = Integer.parseInt(st.nextToken());

		cache = new long[201][201];

		var result = search(N, K);

		System.out.println(result);
	}

	static long search(int n, int k){
		if(k == 0) return 0;
		if(k == 1) return 1;

		if(cache[n][k] != 0){
			return cache[n][k];
		}
		var count = 0L;
		for(int i = 0; i <= N; i++){
			count += search(i, k - 1);
            count %= 1_000_000_000;
		}
		return cache[n][k] = count;
		

	}
}
