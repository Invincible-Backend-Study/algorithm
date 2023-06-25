import java.io.*;
import java.util.*;

public class Boj2839{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var answer = Integer.MAX_VALUE;
		var count = 0;
		while(N > 0) {
			if(N % 5 == 0){
				answer = Math.min(answer, count + N / 5);
			}
			else if(N % 3 == 0){
				answer = Math.min(answer, count + N / 3);
			}
			N -= 5;
			count++;
		}

		if(answer == Integer.MAX_VALUE){
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
}
