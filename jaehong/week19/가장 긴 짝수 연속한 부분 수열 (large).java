import java.io.*;
import java.util.*;

public class Boj22862{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		var st = new StringTokenizer(br.readLine());

		var N = Integer.parseInt(st.nextToken());
		var K = Integer.parseInt(st.nextToken());

		var arr = new boolean[N];
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken()) % 2 == 0;
		}

		var ll = 0;
		var rl = 0;
		var count = 0;
		var answer = 0;
		while(rl < N){
			if(count < K){
				if(!arr[rl]){
					count++;
				}
				rl++;

				answer = Math.max(rl - ll - count, answer);

				continue;
			}
			if(arr[rl]){
				rl++;
				answer = Math.max(rl - ll - count, answer);
				continue;
			}
			
			if(!arr[ll]){
				count--;
			}
			ll++;
		}
		System.out.println(answer);


	}
}
