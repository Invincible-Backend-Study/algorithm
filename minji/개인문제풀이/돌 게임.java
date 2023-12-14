import java.io.IOException;

public class Main {
    private static int N;
    private static String answer;

    public static void main(String[] args) throws Exception {
        input();

        answer = solution();

        output();
    }

    private static String solution() {
        int pick3StoneTurn = N / 3;
        int pick1StoneTurn = N % 3;

        if ((pick3StoneTurn % 2 == 0 && pick1StoneTurn % 2 == 1)
                || (pick3StoneTurn % 2 == 1 && pick1StoneTurn % 2 == 0)) {
            return "SK";
        }

        return "CY";
    }

    private static void input() throws Exception {
        N = readInt();
    }

    private static void output() {
        System.out.println(answer);
    }

    static int readInt() throws IOException {
        int val = 0;
        boolean negative = false;

        while (true) {
            int c = System.in.read();
            if (c == ' ' || c == '\n' || c == -1) {
                break;
            }
            if (c == '-') {
                negative = true;
                continue;
            }
            val = 10 * val + c - 48;
        }

        return negative ? -val : val;
    }
}

