/*
    잘랐을때 가장 많은 종이 조각을 얻기 위해선 가로, 세로로 자른 횟수가 동일할때입니다.
    따라서 한 방향으로 최대 N / 2번까지 자르고, 나머지 방향에 대해 계산하면 됩니다.

    1 ~ N / 2까지 탐색하는데
    반대 방향까지 잘랐을때 개수를 구해 K값과 비교해 이분탐색을 적용할 수 있습니다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int l = 0;
        int r = n / 2;

        while (l < r) {
            int mid = (l + r) / 2;
            long paperCount = (mid + 1L) * (n - mid + 1L);
            if (paperCount >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        long paperCount = (l + 1L) * (n - l + 1L);

        if (paperCount == k) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
    }
}
