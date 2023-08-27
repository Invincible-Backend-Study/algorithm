import java.io.*;
import java.util.*; 


/**
 * 
 * K와 R로 구성되어있는 문자열에서 가장 긴 KRK패턴을 찾아야 합니다.
 *
 * 
 * R로만 이루어진 문자열은 ㅋㅋ루ㅋㅋ 문자열이다
 *
 * R문자열 양 끝에 K를 하나씩 붙인 문자열도 ㅋㅋ루ㅋㅋ문자열이다.
 *
 * K - 아님
 * KR - 맞음 
 * RK - 맞음
 * KRK - 맞음
 * KKRK - 맞음
 *
 * 지워서 부분 수열이면 
 * 
 * KRRRRRK 
 *
 * 
 * R개수를 먼저 세면서 1씩 늘려가고
 * 시작이 K면 참고 중간이 K면 
 *
 * 스택으로 풀 것 같은데?
 *
 * K가 들어오고 R이 들어오는 경우
 *
 * K의 경우 
 *
 * 
 **/

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		var input = br.readLine();
		var size = input.length();

		if("K".repeat(size) == input){
			System.out.println(0);
			return ;
		}
		if("R".repeat(size) == input){
			System.out.println(size);
			return ;
		}


		var lc = new ArrayList<Integer>();
		var rc = new ArrayList<Integer>();


		var count = 0;
		for(var element: input.toCharArray()){
			if(element == 'K') count++;
			else lc.add(count);
		}
		count = 0;
		for(int i = size -1; i >= 0; i--){
			var element = input.charAt(i);

			if(element == 'K') count++;
			else rc.add(count);
		}
		
		rc.sort(Comparator.reverseOrder());
		var ll = 0;
		var rl = rc.size() - 1;
		var max = 0;
		while(ll <= rl){
			max = Math.max(max, (rl - ll + 1) + (2 * Math.min(lc.get(ll), rc.get(rl))));

			if(lc.get(ll) < rc.get(rl)) ll++;
			else rl--;
		}
		System.out.println(max);

		
	}
}
