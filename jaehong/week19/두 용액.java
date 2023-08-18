import java.io.*; 
import java.util.*;

/*
 
   -99 -2 -1 4 98


   1 2 3 4 5

   1 2 10 20 30

   포인터가 2개

   0 4

  -10 -9 -8 -7 -6
  
  -999 -4 1 2

  양쪽 끝에서 시작해서

  0과 가장 유사해질때까지 가면 되는 듯?

  양쪽 원소의 합을 구한다음에
  합이 이전 저장한 값보다 크면 오른쪽 끝이 가장 큰 값이라서 앞으로 이동 시키면 될듯


*/
public class Boj2470{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		var N = Integer.parseInt(br.readLine()); 
		var st = new StringTokenizer(br.readLine());


		var arr = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		var start = 0;
		var end = N - 1;

		var limit = Integer.MAX_VALUE;

		int min = 0;
		int max = 0;


		while( start < end){
			var sum = arr[start] + arr[end];
			var abs = Math.abs(sum);

			if(abs < limit){
				limit = abs;
				min = arr[start];
				max = arr[end];
			}

			var a = sum > 0 ? end-- : start++;
		}

		System.out.println(min + " " + max);
	}
}
