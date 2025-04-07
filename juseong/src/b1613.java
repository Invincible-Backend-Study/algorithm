import java.util.*;

public class b1613 {

    /*

    A라는 사건이 B보다 빨리 일어났다라는 값을 입력 받는데 A와 B B와 C가 있다면 A는 C 보다 빨리 일어 났다라는 문제였다
    즉 A와 C가 연결되어있냐를 판단해야 했던 문제였어서 플로이드 와샬을 사용해 그래프들을 연결 시켜놓고 이를 통해 값을 도출해 내야 했던 문제다.

     */



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사건의 개수
        int k = sc.nextInt(); // 사건의 전후 관계의 수

        int[][] arr = new int[n][n];

        for (int i = 0; i < k; i++) {
            int left = sc.nextInt() - 1; // right 보다 빠르게 일어남
            int right = sc.nextInt() - 1;
            arr[left][right] = 1;
            arr[right][left] = -1;
        }
        for (int middle = 0; middle < n; middle++) {
            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    if(arr[from][middle] == 1 && arr[middle][to] == 1) {
                        arr[from][to] = 1;
                    }
                }
            }
        }


        int s = sc.nextInt(); // 알고싶은 사건의 쌍의 수

        for (int i = 0; i < s; i++) {
            int left = sc.nextInt() - 1;
            int right = sc.nextInt() - 1;

            if (arr[left][right] == 1) {
                System.out.println(-1);
            } else if (arr[right][left] == 1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }
}
