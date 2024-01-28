import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Boj14929{
	public static void main(String...args) throws Exception{ 
		var br = new BufferedReader(new InputStreamReader(System.in)); 

		var st = new StringTokenizer(br.readLine());

		var N = Integer.parseInt(st.nextToken());
		var M = Integer.parseInt(st.nextToken());

		var arr = new int[N+1][M+1];

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <=M; j++) arr[i][j] += arr[i][j-1];
			for(int j = 1; j <= M; j++) arr[i][j] += arr[i-1][j];
		}


		var K = Integer.parseInt(br.readLine());

		var sb = new StringBuilder();
		for(int i = 0; i < K; i++){

			//pSum[c][d] - pSum[a - 1][d] - pSum[c][b - 1] + pSum[a - 1][b - 1]
			st = new StringTokenizer(br.readLine());

			var r1 = Integer.parseInt(st.nextToken());
			var c1 = Integer.parseInt(st.nextToken());
			var r2 = Integer.parseInt(st.nextToken());
			var c2 = Integer.parseInt(st.nextToken());

			var sum = arr[r2][c2] - arr[r1-1][c2] - arr[r2][c1 -1] + arr[r1 -1][c1 -1];

			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		
	}
}
