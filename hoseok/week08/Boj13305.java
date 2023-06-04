/*
    도시에 방문하여 우선 다음 도시까지 가는 기름을 구매한다.
    이후 다음 도시부터 끝까지 탐색하면서 현재 도시보다 기름이 비싸다면 해당 도시까지 가는 기름도 구매한다.
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] distances = new int[n];
        int[] prices = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[n];
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (!visited[i]) {
                sum += (long) distances[i + 1] * prices[i];
                visited[i] = true;
                for (int j = i + 1; j < n - 1; j++) {
                    if (prices[i] <= prices[j]) {
                        visited[j] = true;
                        sum += (long) prices[i] * distances[j + 1];
                    } else {
                        break;
                    }
                }
            }
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}

/*
    풀이2 (풀이 1번의 개념을 조금 더 최적화한 풀이)
    
    도시에 방문하여 우선 다음 도시까지 가는 기름을 구매한다.
    이후 다음 도시부터 끝까지 탐색하면서 현재 도시보다 기름이 비싸다면 해당 도시까지 가는 기름도 구매한다.
    
    위의 말은 결국 각 도시로 가는 기름값을 내림차순으로 변경한것과 동일하다.
    
    각 도시로 가는 기름값이 8 9 10 7 8 2라면
    8 8 8 7 7 2로 계산된다.
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] distances = new int[n];
        int[] prices = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        
        for (int i = 0; i < n - 1; i++) {
            prices[i + 1] = Math.min(prices[i], prices[i + 1]);
            sum += (long) prices[i] * distances[i + 1];
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
