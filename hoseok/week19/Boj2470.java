import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        if (numbers[n - 1] < 0) {
            bw.write(numbers[n - 2] + " " + numbers[n - 1]);
            bw.flush();
            bw.close();
            return;
        } else if (numbers[0] > 0) {
            bw.write(numbers[0] + " " + numbers[1]);
            bw.flush();
            bw.close();
            return;
        }

        int l = 0;
        int r = n - 1;
        int minAbs = Integer.MAX_VALUE;
        int num1 = -1;
        int num2 = -1;

        while (l < r) {
            int numSum = numbers[l] + numbers[r];
            
            if (Math.abs(numSum) < minAbs) {
                minAbs = Math.abs(numSum);
                num1 = numbers[l];
                num2 = numbers[r];
            }
            if (numSum >= 0) {
                r--;
            } else {
                l++;
            }
        }

        bw.write(num1 + " " + num2);
        bw.flush();
        bw.close();
    }
}
