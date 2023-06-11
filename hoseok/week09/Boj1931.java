/*
    최대한 많은 회의를 하기 위해서는 우선 회의의 끝나는 시간의 오름차순으로 정렬을 합니다.
    만약 끝나는 시간이 동일하다면 시작하는 시간의 오름차순으로 정렬하는데 이유는 다음과 같습니다.
    (2, 2), (1, 2)의 회의가 주어졌다면
    1, 2의 회의를 먼저하면 2, 2회의까지 할 수 있지만, 2, 2를 먼저시작하면 1, 2회의를 할 수 없기 때문입니다.
    
    첫번째 회의는 항상 선택하고, 선택한 회의의 끝나는 시간보다 다음으로 선택할 회의의 시작시간이 같거나, 크다면 해당 회의를 선택합니다.
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

        public int compareTo(Meeting meeting) {
            if (this.end == meeting.end) {
                return this.start - meeting.start;
            }
            return this.end - meeting.end;
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
      
        Collections.sort(meetings);
      
        int count = 1;
        int currentEndTime = meetings.get(0).end;
      
        for (int i = 1; i < n; i++) {
            if (currentEndTime <= meetings.get(i).start) {
                count++;
                currentEndTime = meetings.get(i).end;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
