/*
    회의의 시작 시간에 따라 선점되므로 시작시간 기준으로 오름차순 정렬을 합니다.
    
    이후 최소힙을 이용해 회의의 끝 시간을 최소힙에 담습니다.
    이후 다음 회의를 순회하면서 해당 회의의 시작 시간과 최소힙에서 꺼낸 시간보다 크거나 같은 경우에는
    최소힙에서 꺼낸 시간을 대신해 현재 회의의 종료시간을 넣습니다(현재 회의를 동일한 회의실에서 진행하므로 종료시간 변경)
    
    그렇지 않은 경우라면 최소힙에서 꺼낸 종료시간과 현재 회의의 종료시간을 모두 최소힙에 삽입합니다.
*/
import java.io.*;
import java.util.*;

class Main {
    static class Meeting {
        int start, end;
        
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        meetings.sort((o1, o2) -> o1.start - o2.start);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        minHeap.offer(meetings.get(0).end);
        for (int i = 1; i < n; i++) {
            int minEndTime = minHeap.peek();
            if (meetings.get(i).start >= minEndTime) {
                minHeap.poll();
            }
            minHeap.offer(meetings.get(i).end);
        }
        
        bw.write(minHeap.size() + "");
        bw.flush();
        bw.close();
    }
}
