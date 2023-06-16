import java.io.*;
import java.util.*;

public class Boj1092{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var crains = new int[N]; 

		var st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++){
			crains[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crains);

		var M = Integer.parseInt(br.readLine()); 
		var boxes = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++){
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(boxes);

		if(boxes[M-1] > crains[N -1]){
			System.out.println(-1);
			return;
		}

		var up = 0;

		var time = 0;
		var crainIndex = 0;

		while(up != M){
			time++;
			crainIndex = N - 1;

			for(int i = M - 1; i >= 0; i--){
				if(boxes[i] == 0){
					continue;
				}

				if(crainIndex == -1){
					break;
				}
				if(boxes[i] <= crains[crainIndex]){
					crainIndex--;
					up++;
					boxes[i] = 0;
				}
			}
		}
		System.out.println(time);


	}
}
