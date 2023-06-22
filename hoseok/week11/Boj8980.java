/*
    1, 2조건을 봤을때
    박스를 내리는 마을의 크기가 작을수록 결과적으로 더 짧은 경로가 된다는 의미가 됩니다.
    따라서 트럭이 배송할 수 있는 최대 박스 수를 구할때 더 많이 싣게됩니다.

    우선 도착하는 마을의 오름차순으로 정렬을 하고

    해당 마을들을 돌면서 N개 길이의 가중치 배열에 다음과 같이
    - [현재 마을 ~ 도착 마을 - 1] 까지의 범위에 현재마을에서 실을 수 있는 박스의 수를 더해줍니다.
    - 만약 특정 위치에 이미 박스가 더해져 있는 경우에 현재 마을의 박스를 모두 싣게되면 한계중량을 넘는다면 한계중량까지만 담아줍니다.

    위의 과정에서 기록되는 가중치들은 결국 그 순간 트럭이 옮기는 박스가 되므로
    별도의 가중치 변수에 모두 더해주면 최대로 옮길 수 있는 박스가 됩니다.
*/

import java.io.*;
import java.util.*;

class Main {
    static class Delivery {
        int weight, start, end;

        Delivery(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        Delivery[] deliveries = new Delivery[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            deliveries[i] = new Delivery(start, end, weight);
        }
        Arrays.sort(deliveries, Comparator.comparingInt(o -> o.end));

        int sum = 0;
        int[] weights = new int[n];
        for (int i = 0; i < m; i++) {
            int currentMax = 0;
            for (int j = deliveries[i].start - 1; j <= deliveries[i].end - 2; j++) {
                currentMax = Math.max(weights[j], currentMax);
            }
            int sumWeight = Math.min(maxWeight - currentMax, deliveries[i].weight);
            for (int j = deliveries[i].start - 1; j <= deliveries[i].end - 2; j++) {
                weights[j] += sumWeight;
            }
            sum += sumWeight;
        }
        
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
