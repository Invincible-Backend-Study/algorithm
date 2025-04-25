import java.util.*;
import java.io.*;
import java.util.function.*;
import java.util.stream.*;


public class Main {
	public static void main(String...args) throws Exception {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var solution = new Solution();

		var N = toInt(br.readLine());

		var answer = solution.solve(N,br);

	
		p(answer[0] + " " + answer[1]);
	}

	static int toInt(String n){
		return Integer.parseInt(n);
	}
	static int toInt(StringTokenizer st){
		return toInt(st.nextToken());
	}
	static void p(Object o) {
		System.out.println(o);
	}

	static String join(Collection<?> collection, String dlm){
		var sb = new StringBuilder();

		for(var i: collection) sb.append(i.toString()).append(dlm) ;

		return sb.toString();
	}

	static <T> String join(Collection<T> collection, Function<T, String> map, String dlm){
		var sb = new StringBuilder();

		for(var i: collection) sb.append(map.apply(i)).append(dlm) ;

		return sb.toString();
	}


} 

class Solution {

	public int[] solve(int N, BufferedReader br) throws Exception{
		var cache = new int[2][3][2]; 
		for(int i = 1; i <= N; i++){ 
			for(int j = 0; j < 2; j++){ 
				for(int k = 0; k < 3; k++) {
					cache[0][k][0] = cache[1][k][0];
					cache[0][k][1] = cache[1][k][1];
				}
			}
			var st = new StringTokenizer(br.readLine());

			var a = Main.toInt(st);
			var b = Main.toInt(st);
			var c = Main.toInt(st);


			cache[1][0][0] = a + max(cache[0][1][0], cache[0][0][0]);
			cache[1][1][0] = b + max(cache[0][2][0], cache[0][1][0], cache[0][0][0]);
			cache[1][2][0] = c + max(cache[0][2][0], cache[0][1][0]);

			cache[1][0][1] = a + min(cache[0][1][1], cache[0][0][1]);
			cache[1][1][1] = b + min(cache[0][2][1], cache[0][1][1], cache[0][0][1]);
			cache[1][2][1] = c + min(cache[0][2][1], cache[0][1][1]);

		}
		return new int[]{
			max(cache[1][0][0], cache[1][1][0], cache[1][2][0]),
			min(cache[1][0][1], cache[1][1][1], cache[1][2][1])
		};
	}

	static int min(int...arr){
		var min = Integer.MAX_VALUE; 
		for(var e: arr) min = Math.min(e, min);
		return min;
	}

	static int max(int...arr){
		var max = Integer.MIN_VALUE;
		for(var e: arr) max = Math.max(e, max);
		return max;
	}
	static void p(Object o) {
		System.out.println(o);
	}
	static void p(Object...o){
		p(Arrays.toString(o));
	}

	static void p_a(Object[]arr){
		p(Arrays.deepToString((Object[]) arr));
	}
}


