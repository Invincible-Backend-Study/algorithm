import java.io.*;
import java.util.*;

public class Boj4396{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		var N = Integer.parseInt(br.readLine());


		var board = new char[N][N];

		var openFlag = false;
		
		for(int i = 0; i < N; i++){
			board[i] = br.readLine().toCharArray();
		}

		for(int i = 0; i < N; i++){

			var arr = br.readLine().toCharArray();
			for(int j = 0; j< N; j++){
				if(arr[j] == 'x') {
					if(board[i][j] == '*') openFlag = true;
					else board[i][j] = arr[j];
				}
			}
		}
		var dx = new int[]{-1, -1, -1, 1, 1, 1, 0, 0};
		var dy = new int[]{-1, 1, 0, 1, -1, 0, -1, 1};
		for(int i = 0; i < N; i++){
			for(int j = 0; j< N; j++){
				if(board[i][j] == '.') continue;
				if(board[i][j] != 'x') continue;

				var count = 0;
				for(int k = 0; k < 8; k++){
					var nx = i + dx[k];
					var ny = j + dy[k];
					
					if(nx < 0 || ny < 0 ) continue;
					if(nx >= N || ny >= N) continue;
					if(board[nx][ny] == '*') count++;
				}
				board[i][j] = (char)(count + '0');
			}
		}

		var sb = new StringBuilder();
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++) {
				if(openFlag){
					sb.append(board[i][j]);
				}else{
					sb.append(board[i][j] == '*' ? '.' : board[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
