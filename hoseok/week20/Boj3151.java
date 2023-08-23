import java.io.*;
import java.util.*;

class Main {
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                break;
            }
            count += getSumCount(i);
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    public static long getSumCount(int index) {
        long count = 0;
        int fixNumber = arr[index];
        int left = index + 1;
        int right = arr.length - 1;

        while (left < right) {
            int sum = fixNumber + arr[left] + arr[right];

            if (sum == 0) {
                if (arr[left] == arr[right]) {
                    return nCombinationTwo(right - left + 1) + count;
                }

                long leftCount = 1;
                while (arr[left] == arr[left + 1]) {
                    leftCount++;
                    left++;
                }
                left++;

                long rightCount = 1;
                while (arr[right - 1] == arr[right]) {
                    rightCount++;
                    right--;
                }
                right--;

                count += leftCount * rightCount;
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }

    public static long nCombinationTwo(int n) {
        return n * (n - 1) / 2L;
    }
}
