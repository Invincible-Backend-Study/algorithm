import java.io.*;
import java.util.*; 

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		var N = Integer.parseInt(st.nextToken());
		var K = Integer.parseInt(st.nextToken());
		var cnt = new int[100_001];
		var arr = new int[200_001];

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		var ll = 0;
		var rl = 0;
		var result = 0;

		while(ll < N){
			if(cnt[arr[ll]] != K){
				cnt[arr[ll++]]++;
			}else{
				cnt[arr[rl++]]--;
			}
			result = Math.max(result, ll - rl);
		}

		System.out.println(result);
		
		
	
	}
}
