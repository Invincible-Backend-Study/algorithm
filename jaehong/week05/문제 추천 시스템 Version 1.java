import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Boj21939 {

    public static void main(String... args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        var numberOfProblem = Integer.parseInt(br.readLine());
        var set = new TreeMap<Integer, TreeSet<Integer>>();

        while (numberOfProblem-- > 0) {
            var st = new StringTokenizer(br.readLine());
            var number = Integer.parseInt(st.nextToken());
            var level = Integer.parseInt(st.nextToken());

            var problemByLevel = set.getOrDefault(level, new TreeSet<Integer>());

            if (!set.containsKey(level)) {
                set.put(level, problemByLevel);
            }

            problemByLevel.add(number);
        }

        var numberOfCommand = Integer.parseInt(br.readLine());
        while (numberOfCommand-- > 0) {
            var st = new StringTokenizer(br.readLine());

            var command = st.nextToken();
            if ("add".equals(command)) {
                var number = Integer.parseInt(st.nextToken());
                var level = Integer.parseInt(st.nextToken());
                var problemByLevel = set.getOrDefault(level, new TreeSet<Integer>());

                if (!set.containsKey(level)) {
                    set.put(level, problemByLevel);
                }

                problemByLevel.add(number);
                continue;
            }

            if ("recommend".equals(command)) {
                var numberCommand = Integer.parseInt(st.nextToken());

                var problemNumber = switch (numberCommand) {
                    // 난이도가 높고 문제번호가 높은 경우
                    case 1 -> set.get(set.lastKey()).last();
                    default -> set.get(set.firstKey()).first();
                };
                sb.append(problemNumber).append("\n");
                continue;
            }

            // 해결

            var problemNumber = Integer.parseInt(st.nextToken());
            for (var key : set.keySet()) {
                var levelByProblem = set.get(key);

                if (levelByProblem.contains(problemNumber)) {
                    levelByProblem.remove(problemNumber);
                    if (levelByProblem.isEmpty()) {
                        set.remove(key);
                    }
                    break;
                }
            }
        }
        System.out.println(sb);


    }
}
