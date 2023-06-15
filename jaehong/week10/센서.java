import java.io.*;
import java.util.*;


public class Boj2212{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());
		var K = Integer.parseInt(br.readLine());
		var arr = new int[N];
		var st = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		var distance = new int[N - 1];

		for(int i = 0; i < N -1; i++){
			distance[i] = arr[i+1] - arr[i];
		}
		Arrays.sort(distance);
		
		var sum = 0;

		for(int i = 0; i < N - 1 - (K -1); i++){
			sum += distance[i];
		}
	

		System.out.println(sum);
	

	}
}
