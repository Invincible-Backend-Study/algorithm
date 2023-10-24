import java.io.*;
import java.util.*;

class Main {

    private static final int[] sequence = {0, 1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int index = 0;
        int level = 1;
        int count = 0;
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (sequence[i] == target) {
                    count++;
                }
                if (count == t) {
                    bw.write((index % a) + "");
                    bw.flush();
                    bw.close();
                    return;
                }
                index++;
            }
            for (int i = 0; i < (level + 1); i++) {
                if (0 == target) {
                    count++;
                }
                if (count == t) {
                    bw.write((index % a) + "");
                    bw.flush();
                    bw.close();
                    return;
                }
                index++;
            }
            for (int i = 0; i < (level + 1); i++) {
                if (1 == target) {
                    count++;
                }
                if (count == t) {
                    bw.write((index % a) + "");
                    bw.flush();
                    bw.close();
                    return;
                }
                index++;
            }
            level++;
        }

    }
}
