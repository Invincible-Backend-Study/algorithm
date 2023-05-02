/*
    단순하게 Hash 1개를 사용하면 된다.
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> pocketmon = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i);
            String name = br.readLine();
            pocketmon.put(number, name);
            pocketmon.put(name, number);
        }

        StringBuilder result = new StringBuilder();
        while (m-- > 0) {
            result.append(pocketmon.get(br.readLine())).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
