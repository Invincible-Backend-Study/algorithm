import java.io.*;
import java.util.*;

class Main {

    private static int n, minPrice = Integer.MAX_VALUE;
    private static boolean[] visited;
    private static int[] wordCounts, prices;
    private static int[][] bookCounts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] word = br.readLine().toCharArray();
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        wordCounts = new int[26];

        for (char c : word) {
            wordCounts[c - 'A']++;
        }

        prices = new int[n];
        char[][] books = new char[n][];
        bookCounts = new int[n][26];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            prices[i] = Integer.parseInt(st.nextToken());
            books[i] = st.nextToken().toCharArray();
            for (char c : books[i]) {
                bookCounts[i][c - 'A']++;
            }
        }

        combinations(0, 0);

        if (minPrice == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(minPrice + "");
        }
        bw.flush();
        bw.close();
    }

    public static void combinations(int index, int price) {
        if (index == n) {
            calculate(price);
            return;
        }

        visited[index] = true;
        combinations(index + 1, price + prices[index]);
        visited[index] = false;
        combinations(index + 1, price);

    }

    public static void calculate(int price) {
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                for (int j = 0; j < 26; j++) {
                    counts[j] += bookCounts[i][j];
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (wordCounts[i] > counts[i]) {
                return;
            }
        }
        minPrice = Math.min(price, minPrice);
    }
}
