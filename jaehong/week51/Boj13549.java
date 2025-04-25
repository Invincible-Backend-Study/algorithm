import java.util.*;
import java.io.*;
import java.util.function.*;
import java.util.stream.*;


public class Main {
	public static void main(String...args) throws Exception {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var solution = new Solution();


		/*
		 *
		 * 첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다. 
		 * (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N) 둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 공백을 기준으로 구분되어 주어진다. 
		 * 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미다. (1 ≤ A, B ≤ N) 단, A와 B는 서로 다른 자연수이다.
		 */

		var st = new StringTokenizer(br.readLine()); 

		var N = Integer.parseInt(st.nextToken());
		var K = Integer.parseInt(st.nextToken());

		var answer = solution.solve(N, K);

		p(answer);
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

	public int solve(int N, int K){
		
		// n + 1 
		// n * 2
		
		var queue = new PriorityQueue<int[]>((a,b) -> {
			var compare = Integer.compare(a[1],b[1]);
			if(compare == 0) return a[0] - b[0];
			return compare;
		});

		queue.offer(new int[]{N, 0});

		var cache = new HashMap<Integer, Integer>();
		var min = Integer.MAX_VALUE;

		while(!queue.isEmpty()){
			var cur = queue.poll();

			if(cur[0] < 0 && cur[0] != N) continue;
			if(cache.getOrDefault(cur[0], Integer.MAX_VALUE) < cur[1]) continue;
			if(min < cur[1]) {
				break;
			} 

			cache.put(cur[0], Math.min(cache.getOrDefault(cur[0], Integer.MAX_VALUE), cur[1])); 

			if(cur[0] == K) {
				min = Math.min(cur[1], min);
				continue;
			}

			if(cur[0] < K) queue.offer(new int[]{cur[0] + 1, cur[1] + 1});
			if(cur[0] > K) queue.offer(new int[]{K, cur[1] + cur[0] - K});
			else queue.offer(new int[]{cur[0] - 1, cur[1] + 1});
			if(cur[0] != 0 && cur[0] < K) queue.offer(new int[]{cur[0] * 2, cur[1]});
		}

		return min;
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


