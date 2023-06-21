import java.io.*;
import java.util.*;

public class Boj2812{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		var N = Integer.parseInt(st.nextToken());
		var K = Integer.parseInt(st.nextToken());

		var line = br.readLine();

		var stack = new Stack<Character>();
		var count = 0;

		for(int i = 0; i < N; i++){
			var element = line.charAt(i);

			while(count < K && !stack.isEmpty() && stack.peek() < element ){
				stack.pop();
				count++;
			}
			
			stack.push(element);
		}
		
		var sb = new StringBuilder();
		for(var element: stack.toArray()){
			sb.append(element);
		}

		while(count++ < K){
			sb.deleteCharAt(sb.length() - 1);
		}
	
		System.out.println(sb);
	}
	
}
