import java.io.*; 
import java.util.*;

public class Boj20546{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		var N = Integer.parseInt(br.readLine());
		var arr = new int[15];

		var st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 14; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		var p1 = new P(N);
		var p2 = new P(N);
		

	
		int state = 0;
		int prev = arr[0];
		for(int i = 1; i <= 14; i++){
			p1.purchase(arr[i]);

						// 감소하는 경우
			if(arr[i - 1] > arr[i]) {
				if(state > 0) state = 0;
				state += -1;
			}

			// 증가하는 경우 
			if(arr[i - 1] < arr[i]) {
				if(state < 0) state = 0;
				state += 1;

			}
			if(state == -3) {
				p2.purchase(arr[i]);

			}
			if(state == 3) {
				p2.sell(arr[i]);
			}
		}

		var rP1 = p1.calculate(arr[14]);
		var rP2 = p2.calculate(arr[14]);
		
		if(rP1 == rP2) System.out.println("SAMESAME");
		else if(rP1 > rP2) System.out.println("BNP");
		else System.out.println("TIMING");

	
	}
}
class P{
	int money;
	int count = 0; 
	P(int money){
		this.money = money;
	}

	void sell(int price){
		money += count * price;
	}

	void purchase(int price){
		if(money < price) return;
		count += money / price;
		money -= price * (money / price);
	}

	int calculate(int price){
		return this.money + (this.count * price);
	}
}


/*
준현이는 한번 살때 최대한 많이 산다. 
- 대신 이후에 살때도 최대한 많이 산다.


성민이는 세 가지 규칙에 따라 매매한다.
1. 전량 매도, 전량 매수
2. 3일 연속 가격 하라식 다음날은 무조건 매도한다.


19 매수

 * */
