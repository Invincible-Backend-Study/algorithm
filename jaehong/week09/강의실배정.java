import java.io.*;
import java.util.*;


public class Boj11000{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var times = new Time[N];

		for(int i = 0 ; i < N ; i++){
			times[i] = new Time(br.readLine());
		}

		Arrays.sort(times, (t1,t2) -> {
			if(t1.start == t2.start){
				return t1.end - t2.end;
			}
			return t1.start - t2.start;
		});

		var queue = new PriorityQueue<Integer>();
		queue.offer(times[0].end);

		for(int i = 1; i < N;i++){
			if(queue.peek() <= times[i].start){
				queue.poll();
			}
			queue.offer(times[i].end);
		}
		System.out.println(queue.size());

	}
}

class Time{
	int start;
	int end;
	Time(String input){
		var st = new StringTokenizer(input);
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
	}
}


