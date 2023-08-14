import java.io.*;
import java.util.*;

public class Boj3687{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var num = new int[]{0,0,1,7,4,2,0,8,10};
		var minCache = new long[101];


		for(int i = 1; i < 9;i++){
			minCache[i] = num[i];
		}
		minCache[6] = 6;

		for(int i = 9; i < 101; i++){
			minCache[i] = minCache[i-2] * 10 + num[2];

			for(int j=3; j < 8; j++){
				minCache[i] = Math.min(minCache[i], minCache[i-j] * 10 + num[j]);
			}
		}


		var sb = new StringBuilder();
		while(N-- > 0){
			var n = Integer.parseInt(br.readLine());
			sb.append(minCache[n]).append(" "); 

			while(n > 0){
				if(n % 2 != 0){
					sb.append(7);
					n-=3;
				}
				else{
					sb.append(1);
					n-=2;
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);



	}
}
