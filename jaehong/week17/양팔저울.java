import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Boj2629{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		final var itemCount = Integer.parseInt(br.readLine());
		final var items= new int[313131];
		final var cache = new boolean[31][15_001];

		var st = new StringTokenizer(br.readLine());
		for(int i = 0; i < itemCount; i++){
			items[i] = Integer.parseInt(st.nextToken());
		}


		Run run = (self, pos, target) -> {
			if(pos > itemCount || cache[pos][target]) return;
			cache[pos][target] = true;
			self.apply(self, pos +1, target + items[pos]);
			self.apply(self, pos +1, Math.abs(target - items[pos]));
			self.apply(self, pos +1, target);
		};
		run.apply(run, 0, 0);

		var marbleCount= Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		var sb = new StringBuilder();
		for(int i = 0; i < marbleCount; i++){
			var target = Integer.parseInt(st.nextToken());
			if(target > 15000 || !cache[itemCount][target]) sb.append("N ");
			else sb.append("Y ");
		}
		System.out.println(sb);
	}
}

@FunctionalInterface
interface Run{ 
	void apply(Run run, int pos, int target);
}
