import java.io.*;
import java.util.*;

public class Boj2606{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		var n = Integer.parseInt(br.readLine());
		var m = Integer.parseInt(br.readLine());

		var graph = new ArrayList<ArrayList<Integer>>(n+1);

		for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

		for(int i = 0; i < m; i++){
			var st = new StringTokenizer(br.readLine());
			var p = Integer.parseInt(st.nextToken());
			var q = Integer.parseInt(st.nextToken());

			graph.get(p).add(q);
			graph.get(q).add(p);
		}


		var visited = new boolean[n + 1];

		System.out.println(dfs(graph, visited, 1) - 1 );
	}

	static int dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node){
		
		if(visited[node]) return 0;
		
		visited[node] = true;
		var sum = 1;
		for(var child : graph.get(node)) {
			sum +=dfs(graph, visited, child);
		}
		return sum;
	
	}
}
