import java.io.*;
import java.util.*;

public class Boj2578{
	public static void main(String...args ) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		var N = 5;
		var board = new boolean[N][N];

		var table = new HashMap<Integer, Pair>();
		for(int i = 0; i < N; i++){
			var st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				var number  = Integer.parseInt(st.nextToken());
				table.put(number, new Pair(i, j));
			}
		}

		for(int i = 0; i < N; i++){
			var st = new StringTokenizer(br.readLine());

			for(int j = 0; j < N; j++){
				var n = Integer.parseInt(st.nextToken()); 
				var pair = table.get(n);
				board[pair.x][pair.y] = true;
				var count = check(board);
				if(count >= 3) {
					System.out.println(5 * i + j + 1);
					return ;
				}


			}
		}
	}

	static int check(boolean[][] board){
		int count = 0;

		for(int i = 0; i < 5; i++){
			var flag= true;
			for(int j = 0; j < 5; j++){
				if(!board[i][j]) {
					flag = false;
					break;
				}
			}
			if(flag) count++;

			flag = true;
			for(int j = 0; j < 5; j++){
				if(!board[j][i]) {
					flag= false ;
					break;
				}
			}
			if(flag) count++;
		}
		var flag = true;
		for(int i = 0; i < 5; i++){
			if(!board[i][i]){
				flag = false;
				break;
			}
		}
		if(flag) count++;

		flag = true;
		for(int i = 0; i < 5; i++){
			if(!board[i][4 - i]) { 
				flag = false;
				break;
			}
		}
		if(flag) count++;
		return count;



	}
}

class Pair{
	int x;
	int y; 

	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

/*

   25 * 2 * 25 
 * */
