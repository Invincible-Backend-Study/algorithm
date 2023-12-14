import java.io.IOException;
import java.math.BigInteger;

public class Main {
    private static int N;
    private static int M;
    private static BigInteger answer;

    public static void main(String[] args) throws Exception {
        input();

        answer = solution();

        output();
    }

    private static BigInteger solution() {
        BigInteger[] multiplyResult = new BigInteger[101];

        multiplyResult[1] = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            multiplyResult[i] = multiplyResult[i-1].multiply(BigInteger.valueOf(i));
        }

        return multiplyResult[N].divide(multiplyResult[N-M]).divide(multiplyResult[M]);
    }

    private static void input() throws Exception {
        N = readInt();
        M = readInt();
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

/**
 * public class Main {
 *
 * 	public static void main(String[] args) {
 * 		try {
 * 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
 * 			String[] sp = br.readLine().split(" ");
 * 			int n = Integer.parseInt(sp[0]);
 * 			int m = Integer.parseInt(sp[1]);
 *
 * 			BigInteger res = fact(n).divide(fact(m).multiply(fact(n-m)));
 * 			System.out.println(res);
 *                } catch (IOException e) {
 * 			e.printStackTrace();
 *        }* 	}
 *
 * 	public static BigInteger fact(int n) {
 * 		BigInteger bi = new BigInteger("1");
 * 		for (int i = 1; i <= n; i++) {
 * 			bi = bi.multiply(BigInteger.valueOf(i));
 *        }
 * 		return bi;* 	}
 * }
 * https://www.acmicpc.net/source/6335406
 */
