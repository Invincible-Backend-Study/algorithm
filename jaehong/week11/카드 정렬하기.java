import java.io.*;
import java.util.*;

public class Boj1715{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());
		var queue = new PriorityQueue<Integer>();

		for(int i = 0; i <N; i++){
			queue.offer(Integer.parseInt(br.readLine()));
		}
		
		var sum = 0;
		while(queue.size() > 1){
			var element = queue.poll() + queue.poll();
			sum += element;
			queue.offer(element);
		}
		System.out.println(sum);
	}
}
