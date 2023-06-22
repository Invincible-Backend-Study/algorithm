import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		var  N = Integer.parseInt(st.nextToken());
		var  C = Integer.parseInt(st.nextToken());
		var  M = Integer.parseInt(br.readLine());

		var targets = new Target[M];

		for(int i = 0; i < M;i++){
			targets[i] = new Target(br.readLine());
		}

		Arrays.sort(targets, (t1,t2) -> {
			if(t1.end== t2.end){
				return t1.start- t2.start;
			}
			return t1.end - t2.end;
		});


		var box = new int[N+1];
		var acceptable = 0;
		var total = 0;

		for(int i = 0; i < M; i++){
			var t= targets[i];
			var max = 0;

			for(int j = t.start; j < t.end; j++){
				max = Math.max(max, box[j]);
			}
			acceptable = Math.min(C - max, t.count);
			total += acceptable;

			for(int j = t.start; j < t.end; j++){
				box[j] += acceptable;
			}
		}

		System.out.println(total + box[N]);



	}
}

class Target{
	int start;
	int end;
	int count;

	Target(String input){
		var st = new StringTokenizer(input);
		start  = Integer.parseInt(st.nextToken());
		end    = Integer.parseInt(st.nextToken());
		count  = Integer.parseInt(st.nextToken());
	}
}
