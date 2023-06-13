import java.io.*;
import java.util.*;

public class Boj13164{

	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		var N = Integer.parseInt(st.nextToken());
		var K = Integer.parseInt(st.nextToken());
		var arr = new int[N];

		st = new StringTokenizer(br.readLine());

		arr[0] = Integer.parseInt(st.nextToken());
		for(int i = 1 ; i < N ; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			
			arr[i-1] = arr[i] - arr[i-1];
		}
		
		Arrays.sort(arr);

		var sum = 0;
		for(int i = 0; i < N-K; i ++){
			sum += arr[i];
		}
		System.out.println(sum);
	
	}
}
