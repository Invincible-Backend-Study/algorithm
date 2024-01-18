// 이분탐색
import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[][] numbers;
    static int[] aAndB;
    static int[] cAndD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        numbers = new int[4][n];
        aAndB = new int[n * n];
        cAndD = new int[n * n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers[0][i] = Integer.parseInt(st.nextToken());
            numbers[1][i] = Integer.parseInt(st.nextToken());
            numbers[2][i] = Integer.parseInt(st.nextToken());
            numbers[3][i] = Integer.parseInt(st.nextToken());
        }

      int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aAndB[index] = numbers[0][i] + numbers[1][j];
                cAndD[index++] = numbers[2][i] + numbers[3][j];
            }
        }
        Arrays.sort(cAndD);

        long count = 0;
        for (int number : aAndB) {
            int lower = lowerBinarySearch(-number);
            int upper = upperBinarySearch(-number);
            count += (long) upper - lower;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    public static int lowerBinarySearch(int target) {
        int l = 0;
        int r = cAndD.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (cAndD[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int upperBinarySearch(int target) {
        int l = 0;
        int r = cAndD.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (cAndD[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

// 투포인터
import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[][] numbers;
    static int[] aAndB;
    static int[] cAndD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        numbers = new int[4][n];
        aAndB = new int[n * n];
        cAndD = new int[n * n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers[0][i] = Integer.parseInt(st.nextToken());
            numbers[1][i] = Integer.parseInt(st.nextToken());
            numbers[2][i] = Integer.parseInt(st.nextToken());
            numbers[3][i] = Integer.parseInt(st.nextToken());
        }

        // A x B, C x D
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aAndB[index] = numbers[0][i] + numbers[1][j];
                cAndD[index++] = numbers[2][i] + numbers[3][j];
            }
        }
        Arrays.sort(aAndB);
        Arrays.sort(cAndD);

        long count = 0;
        int l = 0;
        int r = n * n - 1;
        while (l < n * n && r >= 0) {
            int sum = aAndB[l] + cAndD[r];

            if (sum == 0) {
                int targetNumber = aAndB[l];
                long abCount = 0;
                while (l < n * n && aAndB[l] == targetNumber) {
                    l++;
                    abCount++;
                }

                targetNumber = cAndD[r];
                long cdCount = 0;
                while (r >= 0 && cAndD[r] == targetNumber) {
                    r--;
                    cdCount++;
                }
                count += abCount * cdCount;
            } else if (sum > 0) {
                r--;
            } else {
                l++;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
