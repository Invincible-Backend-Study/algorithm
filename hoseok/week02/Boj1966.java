/*
   중요도는 1 ~ 9까지이므로 별도의 클래스가 아닌 배열을 통해 저장하고
   인덱스와 중요도 파악을 위한 Node 클래스 사용
*/

import java.io.*;
import java.util.*;

class Node {
    int index, priority;
    Node (int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (caseCount-- > 0) {
            Queue<Node> que = new LinkedList<>();
            
            int[] priorities = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int numCount = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < numCount; i++) {
                int priority = Integer.parseInt(st.nextToken());
                priorities[priority]++;
                que.add(new Node(i, priority));
            }

            int count = 0;
            while (true) {
            
                Node node = que.poll();
                
                if (isHighestPriority(priorities, node.priority)) {
                    priorities[node.priority]--;
                    count++;
                    
                    if (node.index == targetIndex) {
                        result.append(count).append("\n");
                        break;
                    }
                } else {
                    que.offer(node);
                }
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static boolean isHighestPriority(int[] priorities, int priority) {
        for (int i = priority + 1; i <= 9; i++) {
            if (priorities[i] > 0) {
                return false;
            }
        }
        return true;
    }

}
