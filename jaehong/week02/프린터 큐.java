// 추가 개선 예정
// 시간: 72분
// 시간 복잡도 O(N^2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {
    public static void main(String...args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        var numberOfTestCases = Integer.parseInt(br.readLine());
        while(numberOfTestCases-- > 0){
            var st = new StringTokenizer(br.readLine());
            var length = Integer.parseInt(st.nextToken());
            var targetPosition = Integer.parseInt(st.nextToken());
            var count = 0;

            var elements = br.readLine().split(" ");
            Queue<Document> documents = new LinkedList<>();

            // 큐 초기화
            for(int i = 0 ; i< length; i++) {
                documents.offer(new Document(i, Integer.parseInt(elements[i])));
            }

            // 큐에 원소가 없어질때까지
            while(!documents.isEmpty()){
                var document = documents.poll();
                var nowDocumentPrintable = true; // 우선순위 판단 플래그
                for(var doc: documents){
                    // 높은 우선순위를 가진 다른 문서가 있는 경우 플래그를 false 로 변경함
                    if (document.priority < doc.priority) {
                        nowDocumentPrintable = false;
                        break;
                    }
                }
                if(nowDocumentPrintable){
                    count++;
                    if(document.index == targetPosition){
                        break;
                    }
                    continue;
                }
                // 다른 우선순위가 있는 경우 다시 밀어넣음
                documents.offer(document);
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }


}
class Document{
    public int index;
    public int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
