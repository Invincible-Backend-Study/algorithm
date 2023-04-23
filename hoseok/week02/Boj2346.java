/*
    1 2 3 4 5 1 2 3 4 5 -> 원형 큐 -> 덱 이용
    풍선이 순서대로 3 2 1 -3 -1로 존재한다면 일단 덱에 전부 offer함
    풍선의 값이 양수라면 앞에서 맨 앞에서 뽑아서 맨 뒤에 삽입 -> 이후 맨 앞의 값을 뽑음
    풍선의 값이 음수라면 맨 뒤에서 뽑아서 맨 앞에 삽입 -> 이후 맨 앞의 값을 뽑음
*/
import java.io.*;
import java.util.*;

class Node {
    int value, sequence;
    Node(int value, int sequence) {
        this.value = value;
        this.sequence = sequence;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Node> dq = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            dq.offer(new Node(Integer.parseInt(st.nextToken()), i));
        }
        StringBuilder result = new StringBuilder();
        
        Node node = dq.poll();
        result.append("1 ");
        
        while (dq.size() > 1) {
            if (node.value > 0) {
            
                for (int i = 0; i < node.value - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
                node = dq.pollFirst();
                
            } else {
            
                for (int i = 0; i < Math.abs(node.value + 1); i++) {
                    dq.offerFirst(dq.pollLast());
                }
                node = dq.pollLast();
                
            }
            result.append(node.sequence).append(" ");
        }
        result.append(dq.poll().sequence);
        
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
