// 이분탐색
import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] numbers;
    static int[] findNumbers;
    static long total = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            max = Math.max(numbers[i], max);
            min = Math.min(numbers[i], min);
        }
        Arrays.sort(numbers);

        findNumbers = new int[3];

        // 3개의 용액을 비교하기 위해서 적어도 2개의 용액을 찾을 자리는 만들어주어야 합니다.
        for (int i = 0; i < n - 2; i++) {
            binarySearch(i);
        }

        Arrays.sort(findNumbers);
        bw.write(findNumbers[0] + " " + findNumbers[1] + " " + findNumbers[2]);
        bw.flush();
        bw.close();
    }

    public static void binarySearch(int fixedIndex) {
        for (int i = fixedIndex + 1; i < n - 1; i++) {
            long targetNumber = -(numbers[i] + numbers[fixedIndex]);

            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;

                if (numbers[mid] >= targetNumber) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            long sum = Math.abs(numbers[l] - targetNumber);
            if (sum < total) {
                total = sum;
                findNumbers[0] = numbers[i];
                findNumbers[1] = numbers[l];
                findNumbers[2] = numbers[fixedIndex];
            }
            sum = Math.abs(numbers[l - 1] - targetNumber);
            if (l - 1 > i && sum < total) {
                total = sum;
                findNumbers[0] = numbers[i];
                findNumbers[1] = numbers[l - 1];
                findNumbers[2] = numbers[fixedIndex];
            }
        }
    }
}

// 투포인터
import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] numbers;
    static int[] findNumbers;
    static long total = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            max = Math.max(numbers[i], max);
            min = Math.min(numbers[i], min);
        }
        Arrays.sort(numbers);

        findNumbers = new int[3];

        // 3개의 용액을 비교하기 위해서 적어도 2개의 용액을 찾을 자리는 만들어주어야 합니다.
        for (int i = 0; i < n - 2; i++) {
            twoPointer(i);
        }
        
        bw.write(findNumbers[0] + " " + findNumbers[1] + " " + findNumbers[2]);
        bw.flush();
        bw.close();
    }

    public static void twoPointer(int fixedIndex) {
        int l = fixedIndex + 1;
        int r = n - 1;
        
        while (l < r) {
            long sum = numbers[fixedIndex] + numbers[l] + (long) numbers[r];
            
            if (Math.abs(sum) < total) {
                total = Math.abs(sum);
                findNumbers[0] = numbers[fixedIndex];
                findNumbers[1] = numbers[l];
                findNumbers[2] = numbers[r];
            }
            
            if (sum > 0) {
                r--;
            } else if (sum < 0) {
                l++;
            } else {
                break;
            }
        }
    }
}
