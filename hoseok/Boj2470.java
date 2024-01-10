// 투포인터 O(N)
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
        
        int sum = Integer.MAX_VALUE;
        int selectL = -1;
        int selectR = -1;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int curSum = numbers[l] + numbers[r];
            if (Math.abs(curSum) < sum) {
                sum = Math.abs(curSum);
                selectL = l;
                selectR = r;
            }

            if (curSum < 0) {
                l++;
            } else {
                r--;
            }
        }

        bw.write(numbers[selectL] + " " + numbers[selectR]);
        bw.flush();
        bw.close();
    }
}

// 이분탐색 O(NlogN)
import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        // target 숫자와 비교했을때 더하여서 가장 0에 가까운 수 고르기
        int number1 = -1;
        int number2 = -1;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int j = binarySearch(i + 1, n - 1, -numbers[i]);
            int curDiff = Math.abs(numbers[j] + numbers[i]);
            if (curDiff < diff) {
                diff = curDiff;
                number1 = numbers[i];
                number2 = numbers[j];
            }
            if (--j > i && Math.abs(numbers[j] + numbers[i]) < diff) {
                number1 = numbers[i];
                number2 = numbers[j];
                diff = Math.abs(numbers[j] + numbers[i]);
            }
        }

        if (number1 > number2) {
            bw.write(number2 + " " + number1);
        } else {
            bw.write(number1 + " " + number2);
        }
        bw.flush();
        bw.close();
    }

    public static int binarySearch(int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;

            if (numbers[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
