/*
    시작 시간이 빠른 순서로 강의실을 선점하므로 시작시간의 오름차순으로 정렬합니다.

    각 회의를 순회하면서 방문한 회의의 끝나는 시간을 최소힙 우선순위큐에 담습니다.
    이후 다음 회의를 방문할떄 최소힙에서 가장 빨리 끝나는 회의의 끝나는 시간을 꺼내어 비교한다.
    회의를 해당 강의실에서 진행할 수 있다면 현재 방문한 회의의 끝나는 시간을 큐에 삽입한다.

    현재 회의를 진행하는데 새로운 강의실이 필요하다면 해당 회의의 끝나는 시간을 큐에 삽입한다.
*/
import java.io.*;
import java.util.*;

class Main {

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meeting next) {
            return start - next.start;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(meetings);
        
        int count = 1;
        minHeap.offer(meetings.get(0).end);
        
        for (int i = 1; i < n; i++) {
            Meeting currentMeeting = meetings.get(i);
            int minEndTime = minHeap.poll();
            if (currentMeeting.start >= minEndTime) {
                minHeap.offer(currentMeeting.end);
            } else {
                count++;
                minHeap.offer(minEndTime);
                minHeap.offer(currentMeeting.end);
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
