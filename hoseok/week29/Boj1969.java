import java.io.*;
import java.util.*;

class Main {

    private static final char[] symbols = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dnas = new int[m][4];

        for (int i = 0; i < n; i++) {
            String dna = br.readLine();
            for (int j = 0; j < m; j++) {
                char symbol = dna.charAt(j);

                if (symbol == 'A') {
                    dnas[j][0]++;
                } else if (symbol == 'C') {
                    dnas[j][1]++;
                } else if (symbol == 'G') {
                    dnas[j][2]++;
                } else {
                    dnas[j][3]++;
                }
            }
        }

        StringBuilder resultDna = new StringBuilder();
        int hammingDistance = 0;
        for (int i = 0; i < m; i++) {
            int maxCount = 0;
            char symbol = ' ';
            for (int j = 0; j < 4; j++) {
                if (dnas[i][j] > maxCount) {
                    maxCount = dnas[i][j];
                    symbol = symbols[j];
                }
            }
            resultDna.append(symbol);
            hammingDistance += n - maxCount;
        }

        bw.write(resultDna + "\n" + hammingDistance);
        bw.flush();
        bw.close();
    }
}
