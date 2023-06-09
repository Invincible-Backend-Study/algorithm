import java.io.*;
import java.util.*;


public class Boj16953{

	static int min;
	static long B;



	public static void main(String...args) throws Exception{ 
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		var A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		min = Integer.MAX_VALUE;
		
		dfs(A, 1);

		if(min == Integer.MAX_VALUE){
			System.out.println(-1);
			return;
		}
		System.out.println(min);
	}

	static void dfs(long num, int count){
		if(num > B){
			return;
		}

		if(num == B){
			min = Math.min(min,count);
		}

		dfs(num * 2, count+ 1);
		dfs(num * 10 + 1, count+1);
	}
}
	 
