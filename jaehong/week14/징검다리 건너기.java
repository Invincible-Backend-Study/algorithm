import java.io.*;
import java.util.*;

public class Boj21317{
	static int n;
	static int answer = Integer.MAX_VALUE;
	static int[][] arr;
	static int k;

	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n+1][2];

		for(int i = 1; i <= n - 1; i ++){
			var st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		k = Integer.parseInt(br.readLine());

		dfs(0, 1, false);
		System.out.println(answer);
	}

	static void dfs(int sum, int position, boolean check){
		if(position > n){
			return;
		}

		if(position == n){
			answer = Math.min(answer,sum);
			return; 
		}

		dfs(sum + arr[position][0], position+1, check);
		dfs(sum + arr[position][1], position+2, check);

		if(check){
			return;
		}
		dfs(sum + k, position + 3 , true);
	}
}
