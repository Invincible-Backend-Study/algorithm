/*
    에너지 드링크를 최대의 양으로 만들기 위해서는 가장 많이 든것을 놔두고, 나머지 드링크들을 가장 많이 든곳에 부으면 된다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] drinks = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(drinks);

        double sum = drinks[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum += drinks[i] / 2.0;
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
