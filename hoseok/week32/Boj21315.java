import java.io.*;
import java.util.*;

class Main {

    private static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] decks = new int[n];
        for (int k1 = 1; Math.pow(2, k1) < n; k1++) {
            for (int k2 = 1; Math.pow(2, k2) < n; k2++) {
                for (int i = 0; i < n; i++) {
                    decks[i] = i + 1;
                }

                solve(decks, k1);
                solve(decks, k2);

                if (isSame(decks, numbers)) {
                    bw.write(k1 + " " + k2);
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
    }

    public static boolean isSame(int[] decks, int[] numbers) {
        for (int i = 0; i < n; i++) {
            if (decks[i] != numbers[i]) {
                return false;
            }
        }
        return true;
    }

    public static void solve(int[] decks, int k) {
        int range = n;
        for (int i = 1; i <= k + 1; i++) {
            int count = (int) Math.pow(2, k - i + 1);
            shuffle(decks, range, count);
            range = count;
        }
    }

    public static void shuffle(int[] decks, int range, int count) {
        int[] temp = new int[n];

        int index = 0;
        for (int i = range - count; i < range; i++) {
            temp[index++] = decks[i];
            decks[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (decks[i] != 0) {
                temp[index++] = decks[i];
            }
            decks[i] = temp[i];
        }
    }
}
