
import java.util.*;
import java.io.*;
import java.util.function.*;


public class Main {
	public static void main(String...args) throws Exception {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var solution = new Solution();


		// 전처리

		int N = Integer.parseInt(br.readLine());
		
		var words = new ArrayList<String>();

		while(N-- > 0 ) { 
			words.add(br.readLine());
		}

		var answer = solution.solve(words);
		p(join(answer, "\n"));
	}

	static void p(Object o) {
		System.out.println(o);
	}

	static String join(Collection<?> collection, String dlm){
		var sb = new StringBuilder();

		for(var i: collection) sb.append(i.toString()).append(dlm) ;

		return sb.toString();
	}


} 

class Solution {

	// 특정 문자가 이전에 나왔고 다음 문자로 나올 때 중복해서 나오면 문제가 있음
	public List<Integer> solve(List<String> words) {
		var answer = new ArrayList<Integer>();

		for(var word: words) {
			var s = 0;
			var l = word.length() - 1; 

			var sim = 0;
			while(s < l) {
				if(word.charAt(s) == word.charAt(l)) { 
					s++;
					l--;
					continue; 
				}

				var ns = s + 1;
				var nl = l;

				while(ns < nl) {
					if(word.charAt(ns++) != word.charAt(nl--)) {
						sim += 1;
						break;
					}
				}

				ns = s;
				nl = l - 1;

				while(ns < nl) {
					if(word.charAt(ns++) != word.charAt(nl--)){
						sim += 1;
						break;
					}
				}
				sim = Math.max(1, sim);
				
				break;
			}

			answer.add(sim);
		}

		return answer;
	}

	static void p(Object o) {
		System.out.println(o);
	}
}
