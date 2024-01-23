import java.io.*;
import java.util.*;

class Main {

    static class Egg {
        int s, w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }

        public boolean isBreak() {
            return s <= 0;
        }

        public void hitWith(Egg egg) {
            s -= egg.w;
            egg.s -= w;
        }

        public void recovery(Egg egg) {
            s += egg.w;
            egg.s += w;
        }
    }

    static int n;
    static Egg[] eggs;
    static int maxCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        breakEggs(0);

        bw.write(maxCount + "");
        bw.flush();
        bw.close();
    }

    public static void breakEggs(int handleIndex) {
        if (handleIndex == n) {
            int count = 0;
            for (Egg egg : eggs) {
                if (egg.isBreak()) {
                    count++;
                }
            }
            maxCount = Math.max(count, maxCount);
            return;
        }

        // 손에든 계란이 깨졌다면 다음 계란을 들도록 한다
        if (eggs[handleIndex].isBreak()) {
            breakEggs(handleIndex + 1);
            return;
        }
        boolean isAllBreak = true;
        for (int i = 0; i < n; i++) {
            if (handleIndex == i) {
                continue;
            }
            // 치려는 계란이 안깨졌다면 칠 수 있음
            if (!eggs[i].isBreak()) {
                eggs[handleIndex].hitWith(eggs[i]);
                isAllBreak = false;
                breakEggs(handleIndex + 1);
                eggs[handleIndex].recovery(eggs[i]);
            }
        }
        // 치려는 계란이 다 깨진경우 다음 계란을 들도록 함
        if (isAllBreak) {
            breakEggs(handleIndex + 1);
        }
    }
}
