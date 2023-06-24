import java.io.*;
import java.util.*;

public class Boj9655{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N  = Integer.parseInt(br.readLine());


		System.out.println(N % 2 == 0 ? "CY" : "SK");
	}
}
