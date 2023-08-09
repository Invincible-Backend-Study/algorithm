import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		var n = Integer.parseInt(st.nextToken());
		var m = Integer.parseInt(st.nextToken());

		var cache = new long[n+1][m+1]; 

		var input = br.readLine();
		var answer = br.readLine();

		
		for(int i = 1; i <= input.length(); i++){
			cache[i][0] = i;
		}
		for(int j = 1; j <= answer.length(); j++){
			cache[0][j] = j;
		}


		for(int j = 1; j <= answer.length(); j++) {
			for(int i = 1; i <= input.length(); i++){
				var o = input.charAt(i - 1);
				var p = answer.charAt(j - 1);
				if(isEqualTo(o, p)){
					cache[i][j] = cache[i - 1][j - 1];
				}
				else{
					cache[i][j] = 1 +  Math.min(cache[i-1][j-1] ,
							Math.min(cache[i][j-1] , cache[i - 1][j] )
					);
				}
			}
		}

		System.out.println(cache[input.length()][answer.length()]);
	}
	static boolean isEqualTo(char o, char p){
		if(o == p) return true;
		if(o == 'i' && (p == 'i' || p == 'j' || p == 'l')) return true;
		return (o == 'v' && (p == 'v' || p == 'w'));
	}

}

