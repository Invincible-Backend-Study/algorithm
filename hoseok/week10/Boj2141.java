import java.io.*;
import java.util.*;

class Main {
    static class Town {
        int index, people;

        Town(int index, int people) {
            this.index = index;
            this.people = people;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.index));
        long totalCount = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            totalCount += people;
            pq.offer(new Town(index, people));
        }

        long peopleCount = 0;
        int findIndex = 0;
        for (int i = 0; i < n; i++) {
            Town town = pq.poll();
            peopleCount += town.people;
            if (peopleCount >= (totalCount + 1) / 2) {
                findIndex = town.index;
                break;
            }
        }

        bw.write(findIndex + "");
        bw.flush();
        bw.close();
    }
}
