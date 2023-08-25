import java.io.*;
import java.util.*;

// 42m
/**
 * 눈덩이 N개
 * arr[i] = i번째 눈덩이의 높이
 *
 * 하나의 눈사람은 2개의 눈덩이로 구성
 *
 * N개 중 2개를 골라 눈사람을 만듦
 *
 * 두 사람이 만든 눈사람의 키가 최소가 되도록 만듦
 *
 *
 * a b c d
 *
 * (a + b) (c + d)
 *
 * 3 5 2 5 9
 *
 * 2 3 5 5 9
 *
 * 2 9 11
 * 3 5 8
 * 
 * 3 
 *
 * 2 5 7
 * 3 5 8
 *
 *
 * 1 8 9 10 11 12
 * 9 10 19
 * 8 11 19
 * 
 * 바깥쪽과 안쪽 이렇게 2가지 포인트를 잡고 간다.
 *
 * [()] [] -> A
 * () -> B
 * 
 * A가 큰 경우 [(]) -> 이렇게 바깥 쪽에 있는 것을 이동 시킨다.
 * B가 큰 경우 ([)] -> 이렇게 이동 한다.
 *
 * 포인터가 
 *
 * 2 3 5 5 9
 * 3 9 11
 * 2 5 7
 *  
 * 
 *
 * 1 1 1 1 1 1 1 1
 *
 * 0 7
 * 둘의 종료 조건은 언제 인가?
 *
 * [0,1] [6,7]
 * [1,2] [5,6]
 * [2,3] [4,5]
 * 
 */

public class Boj20366{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var st = new StringTokenizer(br.readLine());

		var arr = new int[N]; 

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);


		var answer = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++){
			for(int j = i + 3; j < N; j++){
				var lsum = arr[i] + arr[j];
				
				var ll = i + 1;
				var rl = j - 1;
				while(ll <= rl ){
					var asum = arr[ll] + arr[rl];
					answer = Math.min(answer, Math.abs(lsum - asum));

					if(lsum <= asum) rl--;
					else ll++;
				}
			}
		}
		System.out.println(answer);

		
	}
}
