import java.util.*;

public class b2109 {
    //https://www.acmicpc.net/problem/2109
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n 개의 요청

        // p 와 d 가 들어감
        // p 는 강연료
        // d 는 d일까지

        // 내생각
        // d일안에와서 해주면 되니 d일보다 현재 날짜가 작거나 같을때 최대 비요을 주는 강의를 선택하면 된다
        // 근데 틀림

        /*
        아래와 같은 테스트 케이스 때문에 틀림
        이 문제에서 중요한 것은 d일안에 강연을 선택하는 것이지 d일째에만 강연을 선택하는 것이 아님
        즉 d일안에 선택할 수 있는 값중 최대의 값을 선택해야하는 것

        3

        1 1

        10 2

        10 2

        정답 20
         */

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) { // 금액이 같다면
                return o2[1] - o1[1]; // 내림차순
                // 내림차순 하는 이유는 강연날짜를 최대한 미룰 수 있다면 미루는게 좋기 떄문
                // 어떤 것을 3일차에 진행했다면 2일차와 1일차에만 진행할 수 있는 것들이 선택할 수 있게 됨
                // 만약 강연날짜를 1과 2일쨰에하면 다른 1과 2일째에만 할 수 있는 강연들을 선택못하게됨
            }
            return o2[0] - o1[0];
        });
        int max = 0;
        for (int i = 0; i < n; i++) {
            //p와 d
            //비용과 날짜
            int p = sc.nextInt();
            int d = sc.nextInt();
            max = Math.max(max, d);
            queue.add(new int[]{p, d});
        }


        boolean[] check = new boolean[n + 1];
        int result = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int p = cur[0];
            int d = cur[1];

            for (int i = d; i >= 1; i--) {
                if (!check[i]) {
                    check[i] = true;
                    result += p;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
