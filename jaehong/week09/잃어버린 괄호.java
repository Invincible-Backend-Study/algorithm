import java.io.*;
import java.util.*; 


public class Boj1541{
	public static void main(String...args)throws Exception{

		var br = new BufferedReader(new InputStreamReader(System.in));

		var input = br.readLine();
		var splitStr =  input.split("(?=[-+])|(?<=[-+])");

		var sum = 0; 
		var temp = 0;
		var flag = false;


		for(int i = 0; i < splitStr.length;i++){
			if(splitStr[i].equals("-")){
				if(flag){
					sum -= temp;
					temp = 0;
					continue;
				}
				flag = true;
				continue;
			}
			if(splitStr[i].equals("+")){
				continue;
			}
			if(flag){
				temp += Integer.parseInt(splitStr[i]);
				continue;
			}
			sum += Integer.parseInt(splitStr[i]);
		}
		if(temp != 0) {
			sum -= temp;
		}

		System.out.println(sum);
	}
}
