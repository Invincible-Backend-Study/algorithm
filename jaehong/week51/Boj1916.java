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


		var N = Integer.parseInt(br.readLine());
		var M = Integer.parseInt(br.readLine());

		var map = new HashMap<Integer, List<int[]>>();

		for(int i = 0; i < M; i++){
			var st = new StringTokenizer(br.readLine());

			var p = toInt(st.nextToken());
			var q = toInt(st.nextToken());
			var w = toInt(st.nextToken());

			map.putIfAbsent(p, new ArrayList<>());

			map.get(p).add(new int[]{q, w});
		}
		var st = new StringTokenizer(br.readLine());

		var s = toInt(st.nextToken());
		var e = toInt(st.nextToken());

		var answer = solution.solve(N, M, map, s, e);

		p(answer);
	}

	static int toInt(String n){
		return Integer.parseInt(n);
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

	public int solve(int N, int M, Map<Integer, List<int[]>> map, int s, int e){
		var queue = new PriorityQueue<int[]>((p1, p2) -> {
			return p1[1] - p2[1];
		});

		var min = Integer.MAX_VALUE;
		var cache = new int[N+1];
		var visited = new boolean[N+1];
		Arrays.fill(cache, Integer.MAX_VALUE);

		queue.offer(new int[]{s, 0});
		cache[s] = 1;

		while(!queue.isEmpty()){
			var cur = queue.poll();

			if(min < cur[1]) continue;
			if(cur[0] == e) {
				min = Math.min(min, cur[1]);
				continue;
			}

			visited[cur[0]] = true;
			if(!map.containsKey(cur[0])) continue;
			
			for(var child: map.get(cur[0])){
				if(visited[child[0]] || cache[child[0]] < cur[1] + child[1]) continue; 
				cache[child[0]] = cur[1] + child[1];
				queue.offer(new int[]{child[0], cur[1] + child[1]});
			}
		}

		return cache[e];
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


