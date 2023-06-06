/*
    주어진 N개의 운동기구를 정렬한다.
    운동기구의 수가 홀수라면 가장 근손실이 많이 발생하는 운동기구를 혼자 사용하고
    나머지 운동기구를 가장 적은 근손실이 발생하는 운동기구 + 가장 큰 손실이 발생하는 운동기구를 고른다.

    짝수라면 처음부터 가장 적은 근손실 + 큰 근손실로 짝지어서 최대값을 구한다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(numbers);

        long minValue = Long.MIN_VALUE;
        if (n % 2 != 0) {
            minValue = numbers[n - 1];
            for (int i = 0; i < (n - 1) / 2; i++) {
                minValue = Math.max(minValue, numbers[i] + numbers[n - 2 - i]);
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                minValue = Math.max(minValue, numbers[i] + numbers[n - 1 - i]);
            }
        }

        bw.write(minValue + "");
        bw.flush();
        bw.close();
    }
}
