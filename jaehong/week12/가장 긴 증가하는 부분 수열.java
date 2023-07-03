import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		
		var arr = new int[n + 1];
		var cache = new int[n + 1];
		var st = new StringTokenizer(br.readLine());

		for(int i = 1; i <= n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}


		var maxLength = 0;
		for(int i = 1; i <= n; i++){
			var max = 0;
			for(int j = i; j >= 1; j--){
				if(arr[i] > arr[j]){
					max = Math.max(cache[j], max);
				}
			}
			cache[i] = max + 1;
			maxLength = Math.max(cache[i], maxLength);
		}

		System.out.println(maxLength);

	}
}
