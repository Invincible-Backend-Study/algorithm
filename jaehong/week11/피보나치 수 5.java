import java.io.*;
import java.util.*;

public class Main{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var n  = Integer.parseInt(br.readLine());

		var cache = new int[20+1];

		cache[0] = 0;
		cache[1] = 1;
		for(int i = 2; i <= n; i++){
			cache[i] = cache[i-2] + cache[i-1];
		}
		System.out.println(cache[n]);

	}
}
