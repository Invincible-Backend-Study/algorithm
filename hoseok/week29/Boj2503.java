/*
    순열로 모든 경우의 수를 구하고, 이후 N개의 질문에 대해 답변했을때 동일한 답변이 나오면 해당 수를 카운팅한다.
*/

import java.io.*;
import java.util.*;

class Main {

    private static int n;
    private static boolean[] visited;
    private static String[] answers;
    private static int[][] results;
    private static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[10];
        answers = new String[n];
        results = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            answers[i] = st.nextToken();
            results[i][0] = Integer.parseInt(st.nextToken());
            results[i][1] = Integer.parseInt(st.nextToken());
        }

        permutation("", 0);

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    public static void permutation(String numberCombi, int count) {
        if (count == 3) {
            calculateStrikeAndBall(numberCombi);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(numberCombi + i, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculateStrikeAndBall(String number) {
        for (int i = 0; i < n; i++) {
            String actual = answers[i];
            int strike = getStrikeCount(actual, number);
            int ball = getBallCount(actual, number);

            if (results[i][0] != strike || results[i][1] != ball) {
                return;
            }
        }
        count++;
    }

    public static int getStrikeCount(String answer, String correct) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (correct.charAt(i) == answer.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static int getBallCount(String answer, String correct) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (correct.charAt(i) != answer.charAt(i) && isBall(i, answer.charAt(i), correct)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public static boolean isBall(int index, char number, String correct) {
        for (int i = 0; i < 3; i++) {
            if (index == i) {
                continue;
            }
            if (number == correct.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
