import java.io.*;

class Main {

    static String s, t;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = br.readLine();
        t = br.readLine();

        recur(new StringBuilder(t));

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    public static void recur(StringBuilder builder) {
        if (builder.length() == s.length()) {
            if (s.equals(builder.toString())) {
                result = 1;
            }
            return;
        }

        if (builder.charAt(builder.length() - 1) == 'A') {
            recur(new StringBuilder(builder).deleteCharAt(builder.length() - 1));
        }
        if (builder.charAt(0) == 'B') {
            recur(new StringBuilder(builder).deleteCharAt(0).reverse());
        }
    }
}
