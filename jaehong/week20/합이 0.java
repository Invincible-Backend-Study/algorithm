import java.io.*; 
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception { 
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());
		var st = new StringTokenizer(br.readLine());

		var arr = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		

		Arrays.sort(arr);
		var answer = 0L;

		for(int i = 0; i < N; i++){
			if(arr[i] > 0) break;

			var start = i +1; 
			var end = N - 1;

			while(start < end){
				var s = 1;
				var e = 1;
				var current = arr[i] + arr[start] + arr[end];

				if(current == 0){
					if(arr[start] == arr[end]){
						var n = end - start + 1;

						answer += n * (n - 1) / 2;
						break;
					}
					while(start + 1 < end && arr[start] == arr[start + 1]){
						s++;
						start++;
					}
					while(start < end - 1 && arr[end] == arr[end - 1]){
						e++;
						end--;
					}
					answer += s * e;
				}

				if(current > 0) end--;
				else start++;
			}
		}
		System.out.println(answer);
	}
}
