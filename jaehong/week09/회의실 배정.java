import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1931 {
    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var N = Integer.parseInt(br.readLine());
        var room = new Time[N];

        for (int i = 0; i < N; i++) {
            room[i] = new Time(br.readLine());
        }

        Arrays.sort(room, (a, b) -> {
            if (a.end == b.end) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });

        var next = room[0].end;
        var count = 1;
        for (var i = 1; i < N; i++) {
            //System.out.println(room[i].start + " " + room[i].end);
            if (next <= room[i].start) {
                next = room[i].end;
                count++;
            }
        }

        System.out.println(count);
    }
}

class Time {
    int start = 0;
    int end = 0;

    Time(String input) {
        var st = new StringTokenizer(input);
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
}
