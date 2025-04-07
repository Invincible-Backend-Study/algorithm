public class p81302 {
    /*
    대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return
    P는 응시자가 앉아있는 자리를 의미합니다.
    O는 빈 테이블을 의미합니다.
    X는 파티션을 의미합니다.

    규칙에 맞게 되는지 안되는지만 판단하면 되는 문제였다
    아래 대각선은 하였는데 위대각선 구현안해도 됬다;; 테스트 케이스 추가해야할듯
    https://school.programmers.co.kr/learn/courses/30/lessons/81302?language=java
    */

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] str = places[i];

            String[][] waitingRoom = new String[5][5];
            for (int j = 0; j < 5; j++) {
                waitingRoom[j] = str[j].split("");
            }

            int num = 1;

            loop:
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (waitingRoom[j][k].equals("P")) {

                        if (j + 1 < 5 && waitingRoom[j + 1][k].equals("P")) {
                            num = 0;
                            break loop;
                        }

                        if (k + 1 < 5 && waitingRoom[j][k + 1].equals("P")) {
                            num = 0;
                            break loop;
                        }

                        if (j + 2 < 5) {
                            if (waitingRoom[j + 2][k].equals("P") && !waitingRoom[j + 1][k].equals("X")) {
                                num = 0;
                                break loop;
                            }
                        }

                        if (k + 2 < 5) {
                            if (waitingRoom[j][k + 2].equals("P") && !waitingRoom[j][k + 1].equals("X")) {
                                num = 0;
                                break loop;
                            }
                        }

                        if (j + 1 < 5 && k + 1 < 5) {
                            if (waitingRoom[j + 1][k + 1].equals("P")
                                    && (!waitingRoom[j][k + 1].equals("X") || !waitingRoom[j + 1][k].equals("X"))) {
                                num = 0;
                                break loop;
                            }
                        }

                        if (j + 1 < 5 && k - 1 >= 0) {
                            if (waitingRoom[j + 1][k - 1].equals("P")
                                    && (!waitingRoom[j][k - 1].equals("X") || !waitingRoom[j + 1][k].equals("X"))) {
                                num = 0;
                                break loop;
                            }
                        }
                    }
                }
            }
            answer[i] = num;
        }

        return answer;
    }
}
