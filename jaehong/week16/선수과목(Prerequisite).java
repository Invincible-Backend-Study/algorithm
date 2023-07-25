import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static List<List<Integer>> tree = new ArrayList<>();
	static int[] parentNum;
	static int[] answer;

	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		var M = Integer.parseInt(st.nextToken());

		parentNum = new int[N+1];
		answer = new int[N+1];


		for(int i = 0; i <= N; i++){
			tree.add(new ArrayList<>());
		}
		
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());

			var A = Integer.parseInt(st.nextToken());
			var B = Integer.parseInt(st.nextToken());

			tree.get(A).add(B);
			parentNum[B]++;
		}

		topologicalSort();

		var sb = new StringBuilder();
		for(int i = 1; i <= N; i++){
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

	static void topologicalSort(){
		var queue = new LinkedList<Integer>();

		for(int i = 1; i <= N; i++){
			if(parentNum[i] == 0){
				queue.offer(i);
				answer[i] = 1;
			}
		}

		while(!queue.isEmpty()){
			var num = queue.poll();

			for(var i: tree.get(num)){
				parentNum[i]--;

				if(parentNum[i] == 0){
					queue.offer(i);
					answer[i] = answer[num] + 1;
				}
			}
		}
	}
}
