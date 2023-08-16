import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		var N = Integer.parseInt(st.nextToken());
		var X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		var arr = new int[N]; 

		var flag = true;
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] != 0){
				flag = false;
			}
		}

		if(flag){
			System.out.println("SAD");
			return;
		}
		var store = 0;
		for(int i = 0; i < X; i++){
			store += arr[i];
		}
		var answer = store;
		var count = 0;


		var ll = 0;
		var rl = X - 1;

		while(ll <= rl && rl < N - 1){
			store = (store - arr[ll++]) + arr[++rl];
			
			if(answer == store){
				count++;
				continue;
			}

			if(answer < store){
				answer = store;
				count = 0;
			}
		}

		var sb = new StringBuilder();
		sb.append(answer).append("\n").append(count + 1);
		System.out.println(sb);
	
	}

}
