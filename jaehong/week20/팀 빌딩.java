import java.io.*; 
import java.util.*;

/**
 * N명이 팀 빌딩을 진행 함
 *
 * 하나의 팀을 만들기 위해서 개발자 2명이 반드시 필요함
 *
 * 팀 능력치의 계산은
 * 개발자 A와 B사이에 존재하는 다른 개발자 수 x min(A, B)
 *
 * 1 4 2 5
 * 2 x (1)
 * 양 끝에서 위치를 잡고 A,B의 제어는 힘들지만 거리는 제어할 수 있는 값입니다. 그래서 양 끝에서 작은 값을 이동시키는 방향으로 진행하면 더 효율적입니다. 
 * 2
 */
public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var st = new StringTokenizer(br.readLine());
		var arr = new int[N];

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		
		var ll = 0;
		var rl = N-1;
		var max = 0;
		while(ll <= rl){
			var center = (rl - ll -1) * Math.min(arr[ll] , arr[rl]);

			max = Math.max(max,center);
			if(arr[ll] < arr[rl]){
				ll++;
			}else{
				rl--;
			}
		}

		System.out.println(max);

	

	}
}
