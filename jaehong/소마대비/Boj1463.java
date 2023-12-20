// 소마 대비
import java.io.*;
import java.util.*;


public class Boj1463{

	// 정수 X에 사용할 수 있는 연산은 세 가지
	// x 3d
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));

		var N = Integer.parseInt(br.readLine());

		var arr = new int[N + 1];

		if(N <= 3) {
			int answer = switch(N){
				case 1 -> 0;
				case 2 -> 1;
				case 3  -> 1;
				default -> throw new IllegalArgumentException();
			};
			System.out.println(answer);

			return;
		}
		
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;

		for(int i = 4; i <= N; i++){
			int min = arr[i - 1] + 1;
			if(i % 3 == 0) min = Math.min(min, arr[i / 3] +1);
			if(i % 2 == 0) min = Math.min(min, arr[i / 2] +1);
			arr[i] = min;
		}

		System.out.println(arr[N]);
	}
}
