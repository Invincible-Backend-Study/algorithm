import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static String left;
    private static String right;
    private static String str;

    private static int answer;
    private static Map<String, Pair> consonant = new HashMap<>();
    private static Map<String, Pair> vowel = new HashMap<>();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        answer = solution();

        output();
    }

    private static void input() throws Exception {
        left = readString();
        right = readString();
        str = readString();
    }

    private static int solution() {
        consonant.put("q", new Pair(0, 0));
        consonant.put("w", new Pair(0, 1));
        consonant.put("e", new Pair(0, 2));
        consonant.put("r", new Pair(0, 3));
        consonant.put("t", new Pair(0, 4));
        consonant.put("a", new Pair(1, 0));
        consonant.put("s", new Pair(1, 1));
        consonant.put("d", new Pair(1, 2));
        consonant.put("f", new Pair(1, 3));
        consonant.put("g", new Pair(1, 4));
        consonant.put("z", new Pair(2, 0));
        consonant.put("x", new Pair(2, 1));
        consonant.put("c", new Pair(2, 2));
        consonant.put("v", new Pair(2, 3));

        vowel.put("y", new Pair(0, 5));
        vowel.put("u", new Pair(0, 6));
        vowel.put("i", new Pair(0, 7));
        vowel.put("o", new Pair(0, 8));
        vowel.put("p", new Pair(0, 9));
        vowel.put("h", new Pair(1, 5));
        vowel.put("j", new Pair(1, 6));
        vowel.put("k", new Pair(1, 7));
        vowel.put("l", new Pair(1, 8));
        vowel.put("b", new Pair(2, 4));
        vowel.put("n", new Pair(2, 5));
        vowel.put("m", new Pair(2, 6));

        int distance = 0;
        for (int i = 0; i < str.length(); ++i) {
            String c = String.valueOf(str.charAt(i));
            if (consonant.containsKey(c)) {
                Pair positionL = consonant.get(left);
                Pair positionC = consonant.get(c);
                distance += Math.abs(positionL.x - positionC.x) + Math.abs(positionL.y - positionC.y);
                left = c;
            } else {
                Pair positionR = vowel.get(right);
                Pair positionC = vowel.get(c);
                distance += Math.abs(positionR.x - positionC.x) + Math.abs(positionR.y - positionC.y);
                right = c;
            }
        }

        return str.length() + distance;
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

    static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int c = System.in.read();
            if (c == ' ' || c == '\n' || c == -1) {
                break;
            }
            sb.append((char) c);
        }
        return sb.toString();
    }
}