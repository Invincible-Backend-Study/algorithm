import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		var arr = new int[n+1];
		var cache = new boolean[n+1][n+1];
		var st = new StringTokenizer(br.readLine());

		for(int i = 1; i <= n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= n; i++){
			cache[i][i] = true;
		}

		for(int i = 1; i <= n - 1; i++){
			if(arr[i] == arr[i+1]) cache[i][i+1] = true;
		}

		for(int i =2; i < n; i++){
			for(int j = 1; j <= n - i; j++){
				if(arr[j] == arr[j+i] && cache[j+1][j+i-1]){
					cache[j][j+i] = true;
				}
			}
		}

		var m = Integer.parseInt(br.readLine());
		var sb = new StringBuilder();
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			var s = Integer.parseInt(st.nextToken());
			var e = Integer.parseInt(st.nextToken());

			sb.append(cache[s][e] ? 1 : 0).append("\n");
		}

		System.out.print(sb);



	}
}
