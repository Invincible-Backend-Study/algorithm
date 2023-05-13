// 6시간 동안 풀었지만 반례를 못찾아서 결국 정답 참고
// 다시 풀어볼 예정
import java.io.*;
import java.util.*;


public class Boj6416 {

    public static void main(String... args) throws Exception {
        var sc = new Scanner(System.in);
        var sb = new StringBuilder();
        int k = 0;

        while (true) {
            k++;
            var vertex = new HashMap<Integer, Integer>();
            var edge = 0;

            while (true) {
                var start = sc.nextInt();
                var end = sc.nextInt();

                if (start == -1 && end == -1) {
                    return;
                } else if (start == 0 && end == 0) {
                    break;
                }

                vertex.put(start, vertex.getOrDefault(start, 0));
                vertex.put(end, vertex.getOrDefault(end, 0) + 1);
                edge++;
            }

            var root = 0;
            var isTrue = true;
            for (var key : vertex.keySet()) {
                if (vertex.get(key) == 0) {
                    root++;
                    continue;
                }

                if (vertex.get(key) > 1) {
                    isTrue = false;
                    break;
                }
            }

            if (vertex.size() == 0) {
                System.out.println(getSuccessMessage(k));
                continue;
            }
            if (isTrue && root == 1 && edge == vertex.size() - 1) {
                System.out.println(getSuccessMessage(k));
                continue;
            }
            System.out.println(getFailMessage(k));
        }
    }

    static String getSuccessMessage(int k) {
        return String.format("Case %d is a tree.", k);
    }

    static String getFailMessage(int k) {
        return String.format("Case %d is not a tree.", k);
    }
}
