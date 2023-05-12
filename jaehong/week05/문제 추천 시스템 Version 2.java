// 실패 반례를 못찾음

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Boj21944 {
    static TreeMap<Integer, TreeSet<Integer>> levelProblems = new TreeMap<>();
    static TreeMap<Integer, TreeSet<Integer>> groupProblems = new TreeMap<>();
    static HashMap<Integer, Information> table = new HashMap<>();

    public static void main(String... args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var insertCase = Integer.parseInt(br.readLine());

        while (insertCase-- > 0) {
            insertData(new StringTokenizer(br.readLine()));
        }

        var runCase = Integer.parseInt(br.readLine());

        while (runCase-- > 0) {
            var st = new StringTokenizer(br.readLine());
            var command = st.nextToken();

            if ("add".equals(command)) {
                insertData(st);
                continue;
            }
            if ("solved".equals(command)) {
                var number = Integer.parseInt(st.nextToken());
                var information = table.get(number);

                var levelSet = levelProblems.get(information.level);
                var groupSet = groupProblems.get(information.group);

                levelSet.remove(number);
                groupSet.remove(number);

                if (levelSet.isEmpty()) {
                    levelProblems.remove(information.level);
                }
                if (groupSet.isEmpty()) {
                    groupProblems.remove(information.group);
                }

                table.remove(number);

                continue;
            }
            if ("recommend".equals(command)) {
                var group = Integer.parseInt(st.nextToken());
                var division = Integer.parseInt(st.nextToken());
                var result = 0;
                if (division == 1) {
                    result = groupProblems.get(group).last();
                } else {
                    result = groupProblems.get(group).first();
                }
                sb.append(result).append("\n");
                continue;
            }
            if ("recommend2".equals(command)) {
                var division = Integer.parseInt(st.nextToken());
                var result = 0;
                if (division == 1) {
                    result = levelProblems.get(levelProblems.lastKey()).last();
                } else {
                    result = levelProblems.get(levelProblems.firstKey()).first();
                }
                sb.append(result).append("\n");
                continue;
            }
            var division = Integer.parseInt(st.nextToken());
            var level = Integer.parseInt(st.nextToken());

            var result = 0;
            if (division == 1) {
                var key = levelProblems.higherKey(level);
                if (key == null) {
                    if (levelProblems.containsKey(level)) {
                        result = levelProblems.get(level).first();
                    } else {
                        result = -1;
                    }
                } else {
                    result = levelProblems.get(key).first();
                }
            } else {
                var key = levelProblems.lowerKey(level);
                if (key == null) {
                    if (levelProblems.containsKey(level)) {
                        result = levelProblems.get(level).last();
                    } else {
                        result = -1;
                    }
                } else {
                    result = levelProblems.get(key).last();
                }
            }
            sb.append(result).append("\n");


        }
        System.out.print(sb);
    }

    static void insertData(StringTokenizer st) {
        var number = Integer.parseInt(st.nextToken());
        var level = Integer.parseInt(st.nextToken());
        var group = Integer.parseInt(st.nextToken());

        insert(levelProblems, level, number);
        insert(groupProblems, group, number);

        table.put(number, new Information(level, group));

    }

    static void insert(TreeMap<Integer, TreeSet<Integer>> map, int key, int number) {
        var set = map.getOrDefault(key, new TreeSet<Integer>());
        set.add(number);
        if (!map.containsKey(key)) {
            map.put(key, set);
        }
    }
}

class Information {

    int level;
    int group;

    public Information(int level, int group) {
        this.level = level;
        this.group = group;
    }
}
