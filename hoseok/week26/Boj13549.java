import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] positions = new int[100_001];
        Arrays.fill(positions, -1);

        Deque<Integer> dq = new LinkedList<>();
        dq.offer(n);
        positions[n] = 0;
        while (!dq.isEmpty()) {
            int curPosition = dq.poll();

            if (curPosition == k) {
                break;
            }

            if (curPosition * 2 <= 100_000 && positions[curPosition * 2] == -1) {
                dq.offerFirst(curPosition * 2);
                positions[curPosition * 2] = positions[curPosition];
            }
            if (curPosition - 1 >= 0 && positions[curPosition - 1] == -1) {
                dq.offerLast(curPosition - 1);
                positions[curPosition - 1] = positions[curPosition] + 1;
            }
            if (curPosition + 1 <= 100_000 && positions[curPosition + 1] == -1) {
                dq.offerLast(curPosition + 1);
                positions[curPosition + 1] = positions[curPosition] + 1;
            }
        }

        bw.write(positions[k] + "");
        bw.flush();
        bw.close();
    }
}
