// 큐와 리스트를 통해 해결
import java.util.*;

class Solution {
    
    static class Process implements Comparable<Process> {
        int location, priority;
        
        public Process(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Process p) {
            return p.priority - priority;
        }
        
        @Override
        public String toString() {
            return "{location=" + location + ", priority=" + priority + "}\n";
        }
    }
    
    int n;
    List<Process> processes = new ArrayList<>();
    Queue<Process> waitQueue = new LinkedList<>();
    
    public int solution(int[] priorities, int location) {
        this.n = priorities.length;
        for (int i = 0; i < n; i++) {
            Process process = new Process(i, priorities[i]);
            waitQueue.offer(process);
            processes.add(process);
        }
        processes.sort(Comparator.naturalOrder());
        
        int count = 0;
        while (!waitQueue.isEmpty()) {
            Process process = waitQueue.poll();
            
            if (processes.get(0).priority != process.priority) {
                waitQueue.offer(process);
                continue;
            }
            count++;
            processes.remove(process);
            if (process.location == location) {
                return count;
            }
        }
        return -1;
    }
}


// 큐와 입력받은 배열을 정렬하여 인덱싱을 통해 해결
import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int p : priorities) {
            que.offer(p);
        }
        Arrays.sort(priorities);
        int size = priorities.length - 1;
        
        while (!que.isEmpty()) {
            int priority = que.poll();
            
            // 현재 큐에서 뽑은 우선순위가 현재 우선순위와 일치한다면 큐에서 뽑고 다음 우선순위를 살펴봐야 함
            if (priorities[size - answer] == priority) {
                location--;
                answer++;
                if (location < 0) {
                    break;
                }
            } else {
                location--;
                que.add(priority);
                if (location < 0) {
                    location = que.size() - 1;
                }
            }
        }
        
        return answer;

    }
}
