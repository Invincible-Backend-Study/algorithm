
import java.util.*;
import java.io.*;
import java.util.function.*;


public class Main {
	public static void main(String...args) throws Exception {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var sb = new StringBuilder();


		/**
		 *
모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
		 *
		 */

		Function<Character, Boolean> match = (c) -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u';

		while(true) {
			var line = br.readLine();

			if(line.equals("end")) break;

			var count = 0;
			var flag = true;
			for(int i = 0; i < line.length(); i++) {
				var c = line.charAt(i); 

				if(match.apply(c)) count++;
				if(i >= 2 && match.apply(line.charAt(i - 2)) == match.apply(line.charAt(i - 1)) && match.apply(line.charAt(i - 1)) ==  match.apply(line.charAt(i))) {
					flag = false;
					break; 
				}

				if(i >= 1 && (c != 'e' && c != 'o') &&  line.charAt(i - 1) == c) {
					flag = false;
					break;
				}
			}

			sb.append(String.format("<%s> is %sacceptable.", line, count != 0 && flag ? "" : "not "));
			sb.append("\n");
		}
	
		p(sb);
	}

	public static void p(Object o) {
		System.out.println(o);
	}

} 
