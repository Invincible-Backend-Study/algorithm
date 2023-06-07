import java.io.*;
import java.util.*;


public class Boj20365{

	public static void main(String…args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		// 0 blue 1 red
		var colors= new int[2]; 

		var input = br.readLine();
		colors[colorToNumber(input.charAt(0))]+= 1;
		for(int i = 1 ; i < N; i++){
			if(input.charAt(i) != input.charAt(i-1)){
				colors[colorToNumber(input.charAt(i))] += 1;
			}
		}

		var answer = Math.min(colors[0], colors[1]) + 1;
		System.out.println(answer);
	}
	public static int colorToNumber(char c){
		return c == 'B' ? 0: 1;
	}
}
