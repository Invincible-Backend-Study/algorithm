import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int calcDistance(Node node) {
            return Math.abs(r - node.r) + Math.abs(c - node.c);
        }
    }

    static final Set<Character> set = Set.of('q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v');
    static final char[][] pos = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm', ';', ';', ';'}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String line = br.readLine();
        Node left = findPos(st.nextToken().charAt(0));
        Node right = findPos(st.nextToken().charAt(0));

        int distance = 0;
        for (char c : line.toCharArray()) {
            if (set.contains(c)) {
                Node next = findPos(c);
                distance += left.calcDistance(next) + 1;
                left = next;
            } else {
                Node next = findPos(c);
                distance += right.calcDistance(next) + 1;
                right = next;
            }
        }

        bw.write(distance + "");
        bw.flush();
        bw.close();
    }

    public static Node findPos(char c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (pos[i][j] == c) {
                    return new Node(i, j);
                }
            }
        }
        return null;
    }
}
