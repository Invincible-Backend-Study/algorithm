
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
		p(answer);
	}

	static void p(Object o) {
		System.out.println(o);
	}

} 

class Solution {


	// 특정 문자가 이전에 나왔고 다음 문자로 나올 때 중복해서 나오면 문제가 있음
	public int solve(List<String> words) {

		var count = words.size();
		for(var word: words) { 
			var ban = new HashSet<Character>();

			var pre = ' ';
			for(var c: word.toCharArray()){
				if(pre == c) {
					continue;
				}
				if(ban.contains(c) && pre != c) {
					count--;
					break;
				}
				ban.add(c);
				pre = c;
			}
			
		}
		return count; 
	}

	static void p(Object o) {
		System.out.println(o);
	}
}
