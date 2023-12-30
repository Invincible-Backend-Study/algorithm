import java.io.*;
import java.util.*;

public class Boj1789{
	public static void main(String...args) throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var S = Long.parseLong(br.readLine());
		var next = 1L;

		while(S >= next){
			S -= next++;
		}

		System.out.println(next-1);
	}
}
