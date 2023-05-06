import java.io.*;
import java.util.*;


public class Boj4358{

    public static void main(String...args)throws Exception{

        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        var n = 0;
        var map = new HashMap<String,Integer>();

        while(br.ready()){
            n++;
            var input = br.readLine();
            map.put(input, map.getOrDefault(input, 0)+1);
        }


        var keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);


        for(var key: keySet){
            var value = map.get(key);
            var result = ((double) value / (double) n) * 100;
            sb.append(key).append(" ").append(String.format("%.4f", result)).append("\n");
        }

        System.out.println(sb);
    }
}
