/*
    3가지의 케이스를 생각
    1. 왼쪽끝 벌, 오른쪽 끝 벌통, 나머지 벌 위치 잡으면서 최대값
    2. 오른쪽 끝 벌, 왼쪽 끝 벌통, 나머지 벌 위치 잡으면서 최대값
    3. 왼쪽, 오른쪽 모두 벌, 가운데 벌통 위치 잡으면서 최대값을 갱신해가면 됨
    이때 미리 누적합을 구해두고 벌의 위치만 빼주면 간단하게 구할 수 있다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] honeys = new int[n];
        long[] sum = new long[n];

        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
            currentSum += honeys[i];
            sum[i] += currentSum;
        }

        long max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, sum[n - 1] - honeys[0] - honeys[i] + sum[n - 1] - sum[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, sum[n - 1] - honeys[n - 1] - honeys[i] + sum[i] - honeys[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, sum[i] - honeys[0] + sum[n - 2] - sum[i - 1]);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
