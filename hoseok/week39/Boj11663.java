// 시간복잡도 100000 * 2 * log2(100000) - 3_321_928
import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        StringBuilder result = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startNumber = Integer.parseInt(st.nextToken());
            int endNumber = Integer.parseInt(st.nextToken());

            int lower = findIndexByLowerBound(startNumber);
            int upper = findIndexByUpperBound(endNumber);
            result.append((upper - lower)).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static int findIndexByUpperBound(int target) {
        int l = 0;
        int r = n;

        while (l < r) {
            int mid = (l + r) / 2;

            if (numbers[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static int findIndexByLowerBound(int target) {
        int l = 0;
        int r = n;

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
