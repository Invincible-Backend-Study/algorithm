import java.io.*;
import java.util.*;

public class Boj21279{
	public static void main(String...args) throws Exception{
		final var MAX_NUM = 100000;
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		var N = Integer.parseInt(st.nextToken());
		var C = Integer.parseInt(st.nextToken());

		List<Mineral>[] minerals = new ArrayList[MAX_NUM+1];
		var colV = new int[MAX_NUM+1];
		var colC = new int[MAX_NUM+1];

		for(int i = 0; i < N; i ++){
			st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
			if(minerals[y] == null) minerals[y] = new ArrayList<>();
			minerals[y].add(new Mineral(x,v));
		}

		var sum = 0L;
		var max = 0L;
		var count = 0;
		var y = 0;

		for(int x = MAX_NUM; x>= 0; --x){
			while(count < C && y <= MAX_NUM){
				if(minerals[y] == null) {
					y++;
					continue;
				}

				for(var mineral: minerals[y]){
					if(mineral.x <= x) {
						sum += mineral.v;
						count++;
						colV[mineral.x] += mineral.v;
						colC[mineral.x]++;
					}
				}
				y++;
			}
			if(count <= C && max < sum) max = sum;
			if(colC[x] != 0) { 
				sum -= colV[x];
				count -= colC[x];
			}
		}
		System.out.println(max);
	}


}

class Mineral {
	int x;
	int v;

	Mineral(int x, int v){
		this.x = x;
		this.v = v;
	}
}
