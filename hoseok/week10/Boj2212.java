/*
    1 6 9 3 6 7의 경우 오름차순 정렬을 하면 1 3 6 6 7 9로 정렬된다.
    이때 9 - 1 = 9 - 7 + 7 - 6 + 6 - 6 + 6 - 3 + 3 - 1이 되며 식을 정리하면
    9 + (- 7 + 7) + (- 6 + 6) + (- 6 + 6) + (- 3 + 3) - 1 = 9 - 1로 변환됩니다.
    
    위를 통해 알 수 있는 것은 N개의 센서가 주어졌을때 각 센서간의 차이를 M번 더하게 되면 N - M개의 그룹이 생성된다는 것입니다.
    따라서 주어진 센서를 오름차순 정렬하고(중복은 제거) diff를 구합니다.
    
    우리는 K개의 집중국 그룹을 지어야 하므로 N - K번 더하게 되면 N - (N - K)개의 그룹이 생성되는것을 알 수 있습니다.
    여기서 집중국들의 수신 가능 영역의 합(diff의 합)이 최소가 되어야 하므로 오름차순 정렬을 하고 N - K번 순차적으로 더하면 됩니다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensors = new int[n];
        int[] sensorDiffs = new int[n - 1];
        
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);
        for (int i = 1; i < n; i++) {
            sensorDiffs[i - 1] = sensors[i] - sensors[i - 1];
        }
        Arrays.sort(sensorDiffs);
        
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += sensorDiffs[i];
        }
        
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
