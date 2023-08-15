import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in)); 
		var st = new StringTokenizer(br.readLine());

		var N = Integer.parseInt(st.nextToken());
		var M = Integer.parseInt(st.nextToken());

		var arrN = new int[N];
		var arrM = new int[M];

		st = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < N; i++){
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < M; i++){
			arrM[i] = Integer.parseInt(st.nextToken());
		}

		int nStart = 0;
		int mStart = 0;

		var sb = new StringBuilder();
		while(nStart < N &&  mStart < M){
			if(arrN[nStart] < arrM[mStart]){
				sb.append(arrN[nStart++]).append(" ");
				continue;
			}
			sb.append(arrM[mStart++]).append(" ");
		}

		while(nStart < N) sb.append(arrN[nStart++]).append(" ");
		while(mStart < M) sb.append(arrM[mStart++]).append(" ");

		System.out.println(sb);
	}
}
