import java.io.*;
import java.util.*;


class Solution {
	int[] discountRule = new int[]{10, 20, 30, 40};
	int[] answer = new int[]{0, 0};
	int[] selected;
	int[][] users;
	int[] emoticons;
	public int[] solution(int[][] users, int[] emoticons) {

		// 이모티콘에서
		// 할인 집합을 구해야 함
		// 10, 20, 30, 40
		// 4 * 4 * 4 * 4 * 4 * 4
		this.selected = new int[emoticons.length];

		this.users = users;
		this.emoticons = emoticons;

		dfs(0, emoticons.length);
		return answer;
	}

	void dfs (int now, int last){
		if(now == last) {
			calculate();
			return ;
		}
		for(int i = 0; i < discountRule.length;i++){ 
			selected[now] = discountRule[i];
			dfs(now + 1, last);
			
		}
	}

	void calculate(){
		int[] count = new int[]{0, 0};
		for(var user: users){
			int sum = 0;
			for(int i = 0; i < selected.length; i++){
				if(selected[i] >= user[0]) sum += discount(emoticons[i], selected[i]);
			}

			if(user[1] <= sum) count[0] += 1;
			else count[1] += sum;
		}

		if(answer[0] > count[0]) return;
		if(answer[0] < count[0]) {
			answer = count;
			return ;
		}
		if(answer[1] > count[1]) return;
		answer = count;
	}
	int discount(int price, int percent){
		return (int)( price - (price * (percent * 0.01)));
	}
}

