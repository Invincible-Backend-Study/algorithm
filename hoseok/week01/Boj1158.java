/*
    큐를 이용해 k번째가 오기전까진 큐에서 꺼내고 다시 삽입한다.
    k번쨰를 만나게 되면 poll을 하고 응답값에 포함시킨다.
    위 작업을 큐가 빌때까지 반복한다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Queue<Integer> que = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        StringBuilder result = new StringBuilder();
        result.append("<");
        while (que.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                que.offer(que.poll());
            } 
            result.append(que.poll()).append(", ");
        }
        result.append(que.poll()).append(">");
        
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }    
}
