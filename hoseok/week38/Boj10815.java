// 이분탐색 풀이 (lower bound)
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder result = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int number = Integer.parseInt(st.nextToken());

            if (arr[getIndex(number, arr)] == number) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static int getIndex(int number, int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] >= number) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

// 카운팅 정렬 풀이
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[20_000_001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken()) + 10_000_000] = true;
        }

        StringBuilder result = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int number = Integer.parseInt(st.nextToken()) + 10_000_000;
            if (arr[number]) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
