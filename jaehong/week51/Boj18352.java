
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
	

		// 전처리
		var st = new StringTokenizer(br.readLine());

		var N = Integer.parseInt(st.nextToken());
		var M = Integer.parseInt(st.nextToken());
		var K = Integer.parseInt(st.nextToken());
		var X = Integer.parseInt(st.nextToken());

		var map = new HashMap<Integer, List<Integer>>();

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());

			var A = Integer.parseInt(st.nextToken());
			var B = Integer.parseInt(st.nextToken());
			

			map.putIfAbsent(A, new ArrayList<>());

			map.get(A).add(B);
		}


		var answer = solution.solve(N, M, K, X, map);

		p(answer.size() == 0 ? -1 : join(answer, "\n"));
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

	public List<Integer> solve(int N, int M, int K, int X, Map<Integer, List<Integer>> map){


		// X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호
		// 최단거리 k개를 구해야 함
		// 도착 지점은 정하지 않음 k만큼 이동하면 됨
		// dfs 아닌가?
		// 아 최단 거리라서 dfs로 하면 안되네, 다익스트라로 커버쳐야 하는구나
	

		// 0 next 1 dis
		var queue = new PriorityQueue<int[]>((a,b) -> {
			return a[1] - b[1];  
		});

		var cache = new int[N + 1];
		Arrays.fill(cache, -1);

		cache[X] = 0;
		queue.offer(new int[]{X, 0});

		while(!queue.isEmpty()){
			var cur = queue.poll();
			var next = cur[0];
			var dis = cur[1];

			if(!map.containsKey(next)) continue;

			for(var child: map.get(next)) {
				if(cache[child] != -1  && cache[child] <= dis + 1 || dis >= K) continue;

				cache[child] = dis + 1;
				queue.offer(new int[]{child, dis + 1});
			}
		}

		var answer = new ArrayList<Integer>();

		for(int i = 1; i <= N; i++) {
			if(cache[i] == K) answer.add(i);
		}
		return answer;
	}

	static void p(Object o) {
		System.out.println(o);
	}
	static void p(Object...o){
		p(Arrays.toString(o));
	}
}
