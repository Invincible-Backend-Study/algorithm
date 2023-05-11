import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj21942 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));

        // year, month, day, hour, minute, seconds
        //var time = LocalDateTime.of(2021,1,12,1,2,3);

        var st = new StringTokenizer(br.readLine());

        var inputCase = Integer.parseInt(st.nextToken());
        var p = st.nextToken();

        var d = Integer.parseInt(p.substring(0, 3));
        var h = Integer.parseInt(p.substring(4, 6));
        var m = Integer.parseInt(p.substring(7));
        var range = d * 24 * 60 + h * 60 + m;
        var cost = Integer.parseInt(st.nextToken());

        var table = new HashMap<String, String>();
        var record = new HashMap<String, Long>();

        while (inputCase-- > 0) {
            var input = new StringTokenizer(br.readLine());
            var date = input.nextToken();
            var time = input.nextToken();
            var stuff = input.nextToken();
            var user = input.nextToken();

            var key = user + " " + stuff;
            var value = date + " " + time;

            if (!table.containsKey(key)) {
                table.put(key, value);
                continue;
            }

            var format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            var d1 = format.parse(table.get(key)).getTime();
            var d2 = format.parse(value).getTime();

            var diff = ((d2 - d1) / (60 * 1000));
            if (diff > range) {
                record.put(user, record.getOrDefault(user, 0L) + (diff - range) * cost);
            }
            table.remove(key);
        }
        var list = new ArrayList<String>(record.keySet());
        Collections.sort(list);
        if (list.size() == 0) {
            System.out.println(-1);
            return;
        }
        var sb = new StringBuilder();
        for (var key : list) {
            sb.append(key + " " + record.get(key)).append("\n");
        }
        System.out.println(sb);
    }

}
