// 누적합 이용
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + numbers[i];
        }

        int l = 1;
        int r = 1;
        int length = Integer.MAX_VALUE;
        int currentSum;
        while (r <= n) {
            currentSum = sum[r] - sum[l - 1];

            if (currentSum >= s) {
                length = Math.min(r - l + 1, length);
                l++;
            } else {
                r++;
            }
        }

        if (length == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(length + "");
        }
        bw.flush();
        bw.close();
    }
}

// 단순 숫자 배열 이용
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int minLength = Integer.MAX_VALUE;
        int length = 0;
        int sum = 0;
        while (r <= n) {
            if (sum < s) {
                sum += numbers[r++];
                length++;
            } else {
                sum -= numbers[l++];
                length--;
            }
            if (sum >= s) {
                minLength = Math.min(minLength, length);
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }
        bw.write(minLength + "");
        bw.flush();
        bw.close();
    }
}
