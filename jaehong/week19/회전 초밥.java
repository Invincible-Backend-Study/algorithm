import java.io.*;
import java.util.*;

//회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c가
public class Boj15961{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		var n = Integer.parseInt(st.nextToken());
		var d = Integer.parseInt(st.nextToken());
		var k = Integer.parseInt(st.nextToken());
		var c = Integer.parseInt(st.nextToken());

		var arr = new int[n]; 
		var eats = new int[d+1];

		for(int i = 0 ; i < n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}


		var deque = new ArrayDeque<Integer>();
		var cnt = 0; 
		for(int i = 0; i < k; i++){
			deque.addLast(arr[i]);
			if(eats[arr[i]] == 0){
				cnt++;
			}
			eats[arr[i]]++;
		}
		var result = cnt;

		for(int i = 0; i < n; i++){
			var first = deque.poll();
			eats[first]--;
			if(eats[first] == 0) cnt--;

			deque.addLast(arr[(i+k)%n]);
			if(eats[arr[(i+k)%n]] == 0) cnt++;

			eats[arr[(i+k)%n]]++;

			result = Math.max(result, eats[c] == 0 ? cnt+1 : cnt);
		}

		System.out.println(result);


	}
}
