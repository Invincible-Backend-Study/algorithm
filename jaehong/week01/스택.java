// 19:22 
// 스택을 구현하거나 라이브러리 사용하거나.

import java.io.*;
import java.util.*;

public class Boj10828{ 

	private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	private static final Stack<Integer> stack = new Stack<>();
	public static void main(String...args)throws Exception{
		var line = Integer.parseInt(BR.readLine());

		while(line-- > 0){
			var input = BR.readLine();
			var commandAndValue = input.split(" ");
			var command = commandAndValue[0];
			
			if(command.equals("push")){
				stack.push(Integer.parseInt(commandAndValue[1]));
				continue;
			}

			var result = switch(command){
				case "pop" -> stack.empty() ? -1 : stack.pop();
				case "size" -> stack.size();
				case "empty" -> stack.empty() ? 1 : 0;
				case "top" -> stack.empty() ? -1 : stack.peek();
				default -> throw new IllegalArgumentException();
			};

			System.out.println(result);
		}
	}
}
