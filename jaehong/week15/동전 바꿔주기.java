import java.io.*;
import java.util.*;

public class Main{
	static int T, K;
	static int[][] arr;
	static int[][] cache;
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		arr = new int[K][2]; 


		for(int i = 0; i < K; i++){
			var st = new StringTokenizer(br.readLine());

			// 비용
			arr[i][0] = Integer.parseInt(st.nextToken());
			// 개수
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

	
		cache = new int[K][T+1];

		for(int i = 0; i < K; i++){
			Arrays.fill(cache[i], -1);
		}

		System.out.println(search(0,0));
	}

	static int search(int money, int coin){
		// 금액이 같은 경우
		if(money == T){
			return 1;
		}

		// 금액이 초과하는 경우 혹은 코인의 종류를 수집할 수 없는 경우
		if(coin == K || money > T){
			return 0;
		}

		if(cache[coin][money] != -1){
			return cache[coin][money];
		}

		var count = 0;

		// 코인을 순회하면서 계산 
		for(int i = 0; i< arr[coin][1] + 1; i++){
			// 비용 계산
			var price = arr[coin][0] * i;
			count += search(money + price, coin + 1);
		}
		return cache[coin][money] = count;
	}
}
