import java.io.*;
import java.util.*;

class Pair {
    int leftIndex, rightIndex;

    Pair(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }
}

class Main {
    static List<Pair> pairs;
    static List<String> results = new ArrayList<>();
    static String originalFormulas;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String formulas = br.readLine();

        originalFormulas = formulas;
        pairs = findPairBrackets(formulas);
        backtracking(0, formulas);

        results.sort(Comparator.naturalOrder());
        for (String result : results) {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void backtracking(int currentIndex, String formulas) {
        if (currentIndex == pairs.size()) {
            // 삭제한 괄호자리의 공백은 지우고, 초기 식과 동일하지 않은지, 이미 중복된 식이 있는지를 검사하고,
            // 모두 만족하면 결과리스트에 담는다.
            String result = formulas.replaceAll(" ", "");
            if (!result.equals(originalFormulas) && !results.contains(result)) {
                results.add(result);
            }
            return;
        }

        // 지우거나 지우지 않는다. -> 모든 경우를 탐색할 수 있다.
        backtracking(currentIndex + 1, removeBracket(currentIndex, formulas));
        backtracking(currentIndex + 1, formulas);
    }

    // 괄호 삭제
    public static String removeBracket(int currentIndex, String formulas) {
        Pair pair = pairs.get(currentIndex);
        StringBuilder builder = new StringBuilder(formulas);
        builder.replace(pair.leftIndex, pair.leftIndex + 1, " ");
        builder.replace(pair.rightIndex, pair.rightIndex + 1, " ");
        return builder.toString();
    }

    public static List<Pair> findPairBrackets(String formulas) {
        List<Pair> pairs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        char[] sepFormulas = formulas.toCharArray();
        for (int i = 0; i < sepFormulas.length; i++) {
            if (sepFormulas[i] == '(') {
                stack.push(i);
            } else if (sepFormulas[i] == ')') {
                pairs.add(new Pair(stack.pop(), i));
            }
        }
        return pairs;
    }
}
