import java.io.*;
import java.util.*;
import java.math.*;
public class Boj2407{
	public static void main(String...args)throws Exception{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		var n = Integer.parseInt(st.nextToken());
		var m = Integer.parseInt(st.nextToken());

		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;

		for (int i = 0; i < m; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(n - i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
		}

		BigInteger answer = n1.divide(n2);

		System.out.println(answer);
	}

}
