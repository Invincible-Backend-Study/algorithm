/*
    입력받은 크레인의 중량과 박스의 중량을 각각 저장하고, 내림차순 정렬을 합니다.

    크레인과 박스를 비교해, 만약 크레인 중량 >= 박스 중량 이라면 해당 박스를 지우고, 다음 크레인으로 이동합니다.
    만약 크레인 중량 < 박스 중량 이라면 해당 크레인은 유지하고, 다음 박스로 이동합니다.

    위의 과정을 반복하다가 크레인의 끝까지 돌아오게 되면 1초를 증가하고, 다시 위의 과정을 반복합니다.
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> cranes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort(Comparator.reverseOrder());
        boxes.sort(Comparator.reverseOrder());

        if (cranes.get(0) < boxes.get(0)) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }

        int second = 0;
        while (!boxes.isEmpty()) {
            int boxIndex = 0;
            int craneIndex = 0;
            while (craneIndex < n) {
                if (boxes.size() == boxIndex) {
                    break;
                }
                if (cranes.get(craneIndex) >= boxes.get(boxIndex)) {
                    boxes.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }
            second++;
        }

        bw.write(second + "");
        bw.flush();
        bw.close();
    }
}
