
import java.util.*;
import java.util.stream.*;
import java.io.*;


public class Boj2800{
    static class Bracket{
        int open;
        int close;

        Bracket(int open, int close){
            this.open = open;
            this.close = close;
        }
    }

    public static void main(String...args) throws Exception{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var input= br.readLine();
        var line = input.split("");

        var stack = new ArrayDeque<Integer>();
        var pair = new ArrayList<Bracket>();
        var answer = new HashSet<String>();

        for(int i = 0 ; i < line.length;i++){
            var element = line[i];

            if("(".equals(element)){
                stack.push(i);
                continue;
            }
            if(")".equals(element)){
                pair.add(new Bracket(stack.pop(),i));
                continue;
            }
        }

        int len = pair.size();
        // 괄호 쌍의 개수의 부분집합만큼 괄호 삭제
        for(int i = 1; i < (1 << len); i++) {
            var chk= new ArrayList<Integer>();
            var tmp = new StringBuilder(input);
            for(int j = 0; j < len; j++) {
                if((i & (1 << j)) != 0) {
                    var bracket = pair.get(j);
                    chk.add(bracket.open);
                    chk.add(bracket.close);
                }
            }
            chk.sort(Comparator.reverseOrder());
            for(int n : chk){
                tmp.deleteCharAt(n);
            }

            answer.add(tmp.toString());
        }
        System.out.println(answer.stream().sorted().collect(Collectors.joining("\n")));
    }
}
