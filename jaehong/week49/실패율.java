import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        Map<Integer, Integer> counting = new HashMap<>();
        Map<Integer, Double> percent = new HashMap<>();


        for(int i = 1; i <= N + 1; i++) counting.put(i, 0);
        for(var stage: stages){
            counting.put(stage, counting.get(stage) + 1);
        }
        var count = stages.length;
        for(int i = 1; i <= N ; i++){
            if(count <= 0) percent.put(i, 0.0);
            else {
                percent.put(i, counting.get(i) * 1.0 / count);
                count -= counting.get(i);
            } 
        }
        return percent.entrySet()
            .stream()
            .sorted((e1, e2) -> {
                var compared = e2.getValue().compareTo(e1.getValue());
                if(compared == 0) return e1.getKey() - e2.getKey();
                return compared;
            })
            .mapToInt(e -> e.getKey())
            .toArray();
    }
} 

// 실패율 스테이지에 도달했으나 클리어하지 못한 플레이어의 수  스테이지에 도달한 플레이어 수
/*

스테이지 개수 N 
게임을 이용하는 사용자가 현재 멈춰있는 스테이지 번호가 담긴 배열

실패율이 높은 스테이지부터 내림차순


Map<스테이지, 카운팅>

1번 스테이지 부터 -> 실패율 계산
Map<스테이지, 실패율>
정렬

*/
