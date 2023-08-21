import java.io.*; 
import java.util.*;

/*
 
   10_000 이하의 자연수로 이루어진 길이 N짜리 수열이 있음

   수열에서 연속된 수들의 부분합 중에 그 합이 S이상 되는 것 중, 가장 짧은 것의 길이

   
*/
public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		var N = Integer.parseInt(st.nextToken());
		var S = Integer.parseInt(st.nextToken());

		var arr = new int[100_000];
		var answer = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i]  = Integer.parseInt(st.nextToken());

			if(arr[i] >= S){
				answer = 1;
				break;
			}
		}

		if(answer == 1){
			System.out.println(1);
			return ;
		}

		var ll = 0; 
		var rl = 0;
		var sum = arr[0];

		while(ll <= rl && rl < N){
			if(sum < S) {
				sum += arr[++rl];
				continue;
			}else{
				answer = Math.min(answer, rl - ll + 1);
				sum -= arr[ll++];
			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}
