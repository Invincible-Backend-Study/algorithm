
import java.util.*;
import java.io.*;
import java.util.function.*;
import java.util.stream.*;


public class Main {
	public static void main(String...args) throws Exception {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var solution = new Solution();


		// 전처리

		int n = Integer.parseInt(br.readLine());
		
		var N = n;

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

	static <T> String join(Collection<T> collection, Function<T, String> map, String dlm){
		var sb = new StringBuilder();

		for(var i: collection) sb.append(map.apply(i)).append(dlm) ;

		return sb.toString();
	}


} 

class Solution {

	public List<String> solve(List<String> words) {
		var answer = new ArrayList<String>();

		var files = words.stream()
			.map(word -> {
				var list = new ArrayList<String>();
				var sb = new StringBuilder();

				for(var c: word.toCharArray()){
					if(Character.isDigit(c)) {
						sb.append(c);
					}
					else {
						if(sb.length() != 0) {
							list.add(sb.toString());
							sb = new StringBuilder();
						}
						list.add(c + "");
					}
				}

				if(sb.length() !=0) list.add(sb.toString());
			
				return list;
			})
			.collect(Collectors.toList());

		p(files);

		Collections.sort(files, (arr1, arr2) -> {
			var aLen = arr1.size();
			var bLen = arr2.size();
			var len = Math.min(aLen, bLen);

			for(int i = 0; i < len; i++){
				var a = arr1.get(i);
				var b = arr2.get(i);

				var isDigitA = Character.isDigit(a.charAt(0));
				var isDigitB = Character.isDigit(b.charAt(0));

				//p(isDigitA + " " + isDigitB + " " + a.charAt(0));

				// 정수 비교
				if(isDigitA && !isDigitB) return -1;
				if(!isDigitA && isDigitB) return 1;
				if(isDigitA && isDigitB) {

					var adl = a.length();
					var bdl = b.length();
					var l = Math.min(adl, bdl);


					var ll = 0;
					var rl = 0; 

					var lzc = 0;
					var rzc = 0;

					while(ll < a.length() && rl < b.length()){
						if(a.charAt(ll) == '0') {
							ll++;
							lzc++;
							continue;
						}
						if(b.charAt(rl) == '0') {
							rl++;
							rzc++;
							continue;
						}

						var compare = a.charAt(ll) - b.charAt(rl);

						if(compare == 0) {
							ll++;
							rl++;
						}else { 
							return compare;
						}
					}

					if(ll == a.length() && rl == b.length()) {
						if(lzc == rzc) {
							continue;
						}
						return lzc - rzc;
					}

					if(ll == a.length()) return -1;
					if(rl == b.length()) return 1;
				}


				if(a.toUpperCase().equals(b.toUpperCase())) {
					if(a.equals(b)) continue; 
					if(Character.isUpperCase(a.charAt(0))) { 
						return -1;
					}
					return 1;
				}

				// 대소 문자 비교 같은 경우 대문자가 먼저 오도록
			}

			return aLen - bLen;
		});
		
		return files.stream().map(list -> Main.join(list, "")).collect(Collectors.toList());
	}

	static void p(Object o) {
		System.out.println(o);
	}
}


// 아 문제 접근을 잘못함
// 만약 첫 문자가 시작 문자가 다른 경우라면? 
// ex) abb, abcc
// 길이가 2가 됨
// 2번 케이스의 경우 그냥 앞 뒤로 같은 단어만 있으면 된다고 하네요
// 작은 건 쉽게 찾을 수 있겠는데, 큰 건 어떻게 찾아야 하나?
// 두 번 확인해야 하나?
// 슬라이딩 윈도우 접근으로도 문제가 있을 듯?
//
// abcdece                                                        			
// // 일단 없는 단어를 탐색하는건 문제 있음
// 마지막 인덱스 찾는 방법은 어려울 듯?
// 동일한 문자 두 개가 포함된 가장 작은 길이
// 동일한 문자가 앞 뒤로 포함된 가장 긴 길이
//
// 근데 반대로 말하면 시작과 끝에 같은 단어가 포함된 가장 짧고 길이가 긴 문자열을 찾아라 아님?
// 문자 하나 선택하고 다음에 나올 때 까지 찾으면 될 듯? 
