import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var arr = new int[N+1];
		var answer = 0;

		for(int i = 1; i <= N; i++){
			var st = new StringTokenizer(br.readLine());
			var t = Integer.parseInt(st.nextToken());
			var s = Integer.parseInt(st.nextToken());

			if(s == 0){
				arr[i] = t;
				answer = Math.max(answer, arr[i]);
				continue;
			}

			var max = 0;
			for(int j = 0 ; j < s; j++){
				 var k = Integer.parseInt(st.nextToken());
				 max = Math.max(max, arr[k]);
			}
			arr[i] = max + t;
			answer = Math.max(answer, arr[i]);
		}

		System.out.println(answer);
	}
}
