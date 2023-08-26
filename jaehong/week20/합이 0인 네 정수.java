import java.io.*;
import java.util.*; 

public class Boj7453{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var arr = new int[N][4];

		for(int i = 0; i < N; i++){
			var st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
		}

		var preSum = new int[2][N * N];
		var count = 0;
		for(int i = 0; i < N;i++){
			for(int j = 0; j < N; j++){
				preSum[0][count] = arr[i][0] + arr[j][1];
				preSum[1][count++] = arr[i][2] + arr[j][3];
			}
		}

		Arrays.sort(preSum[0]);
		Arrays.sort(preSum[1]);

		var first = 0;
		var second = preSum[0].length - 1;

		var end = N * N;
		var answer = 0L;
		while(first < end && second >= 0){
			var sum = preSum[0][first] + preSum[1][second];
			var firstCnt= 1; 
			var secondCnt= 1;

			if(sum == 0){
				 while (first <= end - 2 && preSum[0][first] == preSum[0][first + 1]) {
                    firstCnt++;
                    first++;
                }
                while (0 < second && preSum[1][second] == preSum[1][second - 1]) {
                    secondCnt++;
                    second--;
                }
                answer += (long) firstCnt * secondCnt;
			}
			if(sum < 0){
				first++;
			}else{
				second--; 
			}
		}

		System.out.println(answer);

	}
}
