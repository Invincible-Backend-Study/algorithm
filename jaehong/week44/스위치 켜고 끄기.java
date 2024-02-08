import java.io.*;
import java.util.*; 


public class Boj1244 {
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		var N = Integer.parseInt(br.readLine());

		var switches = new boolean[N+1];

		var st = new StringTokenizer(br.readLine());

		for(int i = 1; i <= N; i++) switches[i] = Integer.parseInt(st.nextToken()) == 0 ? false : true;

		var M = Integer.parseInt(br.readLine());

		for(int i = 0; i < M; i++){
			

			st = new StringTokenizer(br.readLine());

			var t = Integer.parseInt(st.nextToken());
			var m = Integer.parseInt(st.nextToken());

			if(t == 1){ // 남자
				for(int j = m ; j <= N; j += m) switches[j] = !switches[j];
			}else{
				var index = 1;
				var prev = switches[m];
				switches[m] = !switches[m];
				while(m - index > 0 && m + index <= N){
					if(switches[m - index] == switches[m + index]){
						switches[m - index] = !switches[m - index];
						switches[m + index] = !switches[m + index];
						index++;
					}else break;
				}
			}
		}

		var sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(switches[i] ? 1 : 0).append(" ");
			if(i % 20 == 0) sb.append("\n");
		}
		System.out.println(sb);

	

	}
}

/*

1부터 연속적으로 번호가 붙어있는 스위치

스위치의 상태는 ON/OFF 2개의 상태
1 -> ON
2 -> OFF

학생 몇 명을 뽑ㅂ음
1이상이고 스위치 개수 이하인 자연수를 하나씩 나누어줌

성별과 받은 수에 따라 다르게 스위치 함

남학생은 스위치 번호가 자기가 받은 수의 배수이면 스위치의 상태를 바꿈
3번 받으면
3, 6을 끔

여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로
좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치를 모두 바꿈

스위치의 개수는 항상 홀수

010 1 010 
 */
