/*
    어차피 비싼것과 저렴한것을 묶게되면 저렴한것에 대한 돈을 무조건 내야 한다.
    따라서 최대의 효율을 내려면 저렴한것중에서도 가장 비싼것을 골라야 최대한의 이득을 볼 수 있다.
    따라서 내림차순 정렬을 하고, 앞에서부터 3개씩 묶어가면서 2 + 1을 진행하면 된다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);
        
        int sum = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count++;
            if (count % 3 != 0) {
                sum += numbers[i];
            } else {
                count = 0;
            }
        }
        
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
