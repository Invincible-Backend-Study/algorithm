/*
    - 우선순위 큐 2개를 생성한다.
    하나는 최대힙으로 항상 최대값만을 반환한다.
    - 다른 하나는 최소힙으로 항상 최소값을 반환한다.

    -1번째 값은 일단 최소힙에 넣는다. 그리고 위치값을 1로 세팅한다.
    -우선 1번쨰 값을 중앙값으로 받으므로, 이후에 들어오는 숫자를 현재 중앙값과 비교해 크다면 최소힙으로, 작거나 같다면 최대힙으로 offer한다.

    - 만약 작거나 같은 값이 들어오면 위치값을 + 1 증가시킨다.
    이후 다시 3번쨰 수를 입력받게되면 출력을 해야한다.

    - 1번째의 중앙값의 위치값과 입력받은 전체 수 / 2 + 1의 값을 비교한다.
      - 만약 1번쨰 중앙값의 위치값 > 전체 수의 개수 / 2 + 1 이라면 다음중앙값은 현재 중앙값보다 더 작은 수이고 그 차는
        (전체 수 개수 / 2 + 1) - 1번쨰 중앙값의 위치값이다. 따라서 최대힙에서 최소힙으로 해당 차만큼 이동시킨다.
        - 중앙값은 최대힙의 peek을 가진다.
     - 반대로 1전째 중앙값의 위치값이 더 작은 경우는 해당 차 만큼 최소힙 -> 최대힙으로 이동시키고 최대힙의 peek이 중앙값이 된다.
*/

import java.io.*;
import java.util.*;

class Main {
    private static final int OFFSET = 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        List<List<Integer>> totalResults = new ArrayList<>();

        while (testCase-- > 0) {
            int m = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<Integer> results = new ArrayList<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            
            int middleNumber = Integer.parseInt(st.nextToken());
            int currentPosition = 1;
            maxHeap.offer(middleNumber);
            results.add(middleNumber);
            
            for (int i = 2; i <= m; i++) {
                int number = Integer.parseInt(st.nextToken());
                
                // 10개 넘으면 다음 줄을 받아야 한다.
                if (i % OFFSET == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                
                if (middleNumber < number) {
                    minHeap.offer(number);
                } else {
                    maxHeap.offer(number);
                    currentPosition++;
                }

                if (i % 2 == 1) {
                    int rightPosition = getRightPosition(i);
                    if (currentPosition > rightPosition) {
                        moveHeapToHeap(Math.abs(rightPosition - currentPosition), maxHeap, minHeap);
                    } else if (currentPosition < rightPosition) {
                        moveHeapToHeap(Math.abs(rightPosition - currentPosition), minHeap, maxHeap);
                    }
                    middleNumber = maxHeap.peek();
                    currentPosition = rightPosition;
                    results.add(middleNumber);
                }
            }
            totalResults.add(results);
        }

        StringBuilder totalResultsBuilder = new StringBuilder();
        
        for (List<Integer> results : totalResults) {
            totalResultsBuilder.append(results.size()).append("\n");
            StringBuilder resultBuilder = new StringBuilder();
            
            for (int i = 0; i < results.size(); i++) {
                
                // 10개째라면 붙이고 다음줄로 이동
                if (i % (OFFSET - 1) == 0) {
                    resultBuilder.append(results.get(i)).append("\n");
                    continue;
                }
                resultBuilder.append(results.get(i)).append(" ");
            }
            totalResultsBuilder.append(resultBuilder.toString().trim()).append("\n");
        }

        bw.write(totalResultsBuilder.toString());
        bw.flush();
        bw.close();
    }
    
    public static void moveHeapToHeap(int moveCount, PriorityQueue<Integer> from, PriorityQueue<Integer> to) {
        while (moveCount-- > 0) {
            to.offer(from.poll());
        }
    }

    public static int getRightPosition(int currentNumber) {
        return currentNumber / 2 + 1;
    }
}
