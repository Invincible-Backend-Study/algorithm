/*
    최소힙으로 구성된 우선순위큐를 만든다.

    이후 파일을 2개씩 뽑아서 별도의 누적합 변수에 더하여 저장하고, 더한 값은 다시 우선순위큐에 삽입한다.

    우선순위큐에 포함된 원소가 1개라면 종료한다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        while (testCase-- > 0) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            offerAll(st, pq);

            long totalSum = 0;
            while (pq.size() > 1) {
                long sum = pq.poll() + pq.poll();
                totalSum += sum;
                pq.offer(sum);
            }
            result.append(totalSum).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void offerAll(StringTokenizer st, PriorityQueue<Long> pq) {
        while (st.hasMoreTokens()) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
    }
}
