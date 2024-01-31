import java.io.*;
import java.util.*; 


public class Boj27960{
	public static void main(String...args) throws Exception{ 
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		var A = Integer.parseInt(st.nextToken());
		var B = Integer.parseInt(st.nextToken());

		// 1 2 4 8 16 32 64 128 256 512 

		// 둘 중 한명 만 맞힌 표적은 다 맞혔는데 
		//
		
		var C = 0; 
		for(int i = 9; i >= 0; i--){
			var flag = false;
			if(A >= 1 << i){
				A -= 1 << i;
				flag = !flag;
			}
			if(B >= 1 << i){
				B -= 1 << i;
				flag = !flag;
			}
			if(flag) C += 1 << i;
		}
	
		System.out.println(C);



	}
}
