import java.io.*;
import java.util.*;

class Main {

    static final boolean[] check = new boolean[26];
    static {
        check[0] = true;
        check[4] = true;
        check[8] = true;
        check[14] = true;
        check[20] = true;
    }
    static long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] words = br.readLine().toCharArray();
        boolean hasL = false;
        for (char c : words) {
            if (c == 'L') {
                hasL = true;
            }
        }

        search(0, words, 1L, 1L, 0, 0, hasL);

        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
    }

    public static void search(int index, char[] words, long countA, long countB, int consonant, int vowel, boolean hasL) {
        if (consonant == 3 || vowel == 3) {
            return;
        }
        if (index == words.length) {
            if (!hasL) {
                return;
            }
            answer += countA * countB;
            return;
        }

        if (words[index] == '_') {
            search(index + 1, words, countA, countB * 20, consonant + 1, 0, hasL);
            search(index + 1, words, countA * 5, countB, 0, vowel + 1, hasL);
            search(index + 1, words, countA, countB, consonant + 1, 0, true);
        } else {
            if (check[words[index] - 'A']) {
                search(index + 1, words, countA, countB, 0, vowel + 1, hasL);
            } else {
                search(index + 1, words, countA, countB, consonant + 1, 0, hasL);
            }
        }
    }
}
