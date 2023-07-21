import java.io.*;
import java.util.*;

public class Boj9251{
	static char[] A;
	static char[] B;
	static Integer[][] cache;
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		A =br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		var Al = A.length;
		var Bl = B.length;

		cache = new Integer[Al][Bl];

		search(Al-1, Bl-1);
		System.out.println(cache[Al-1][Bl-1]);
	}

	static int search(int x, int y){

		// 범위를 벗어나는 경우
		if(x == -1 || y == -1){
			return 0;
		}


		// cache hit
		if(cache[x][y] != null){
			return cache[x][y]; 
		}

		if(A[x] == B[y]){
			return cache[x][y] = search(x -1, y-1) +1;
		}
		return cache[x][y] =  Math.max(search(x-1, y), search(x,y -1));
	}
}
