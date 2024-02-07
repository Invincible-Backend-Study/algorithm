import java.util.*;
import java.io.*;


public class Boj21608{

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};

	static int N;
	static int[][] board;
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];


		var friends= new ArrayList<HashSet<Integer>>((N * N) + 1);
		for(int i = 0; i <= N * N; i++) friends.add(null);

		for(int i = 0; i < N * N; i++){
			var st = new StringTokenizer(br.readLine());
			var target = Integer.parseInt(st.nextToken());

			var set = new HashSet<Integer>();

			for(int j = 0; j < 4; j++) set.add(Integer.parseInt(st.nextToken()));
			friends.set(target, set);
			var case1Result = checkCase1(target, set);
			if(case1Result.size() == 1) {
				change(case1Result.get(0), target);
				continue;
			};
			var case2Result = checkCase2(target, case1Result);
			if(case2Result.size() == 1) {
				change(case2Result.get(0), target);
				continue;
			}
			change(checkCase3(case2Result), target);
		}

		var scoreTable = new int[]{0,1,10,100,1000};
		int sum = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				int t = 0;
				for(int k = 0; k < 4; k++){
					var nx = i + dx[k];
					var ny = j + dy[k];

					if(nx < 0 || ny < 0) continue;
					if(nx >= N || ny >= N) continue;

					if(friends.get(board[i][j]).contains(board[nx][ny])) t++;
				}
				sum += scoreTable[t];
			}
		}
		System.out.println(sum);
	}

	static void change(Pair pair, int n){
		board[pair.x][pair.y] = n;
	}

	static Pair checkCase3(List<Pair> pairs){
		var max = pairs.get(0);
		var size = pairs.size();

		for(int i = 1; i < size; i++){
			if(max.x < pairs.get(i).x) continue;
			if(max.x == pairs.get(i).x) {
				if(max.y > pairs.get(i).y) max = pairs.get(i);
			}else max = pairs.get(i);
		}
		return max;
	}

	static List<Pair> checkCase2(int n, List<Pair> pairs){
		List<Pair> result = new ArrayList<>();
		int maxCount = 0;

		for(var pair: pairs){
			int count = 0;
			for(int k = 0; k < 4; k++){
				var nx = pair.x + dx[k];
				var ny = pair.y + dy[k];

				if(nx < 0 || ny < 0) continue;
				if(nx >= N || ny >= N) continue;

				if(board[nx][ny] == 0) count++;
			}
			if(count < maxCount) continue; 
			if(count > maxCount) {
				result.clear();
				maxCount = count;
			}
			result.add(pair);
		}
		return result;
	}

	static List<Pair> checkCase1(int n, Set<Integer> set){
		List<Pair> result = new ArrayList<>();

		int maxCount = 0;

		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(board[i][j] != 0) continue;

				int count = 0;
				for(int k = 0; k < 4; k++){
					var nx = i + dx[k];
					var ny = j + dy[k];

					if(nx < 0 || ny < 0) continue;
					if(nx >= N || ny >= N) continue;


					if(set.contains(board[nx][ny])) count++;
				}

				if(count < maxCount) continue; 
				if(count > maxCount) {
					result.clear();
					maxCount = count;
				}
				result.add(new Pair(i, j));
			}
		}
		return result;
	}
}

class Pair {
	int x;
	int y;
	Pair(int x, int y){
		this.x = x; 
		this.y = y;
	}

	@Override
	public String toString(){
		return "x: " + x + " " + "y: " + y; 
	}
}

/*
   1. 비어 있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다. 
   -> 비어 있는 칸을 탐색하면서 주위에 좋아하는 학생이 몇 명인지 체크

   2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
   -> 1의 선택지 중에서 주위에 가장 많이 비어 있는 칸을 찾음

   3. 2의 만족하는 칸도 여러개인 경우에는 행의 번호가 가장 작은 칸으로

   좌표를 저장하는 방식으로 정해야 할듯


   번호 - 좋아하는 번호 목록
   */

