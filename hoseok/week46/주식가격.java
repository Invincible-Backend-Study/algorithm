// 스택 사용
import java.util.*;

class Solution {

    static class Stock {
        int price, time;

        public Stock(int price, int time) {
            this.price = price;
            this.time = time;
        }

        @Override
        public String toString() {
            return "{ price=" + price + ", time=" + time + "} ";
        }
    }

    int n;

    public int[] solution(int[] prices) {
        this.n = prices.length;
        int[] answer = new int[n];
        Deque<Stock> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 주식 가격이 떨어진다면 현재 주식에 의해 값이 떨어지는 모든 주식을 제거해야 함
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                Stock descStock = stack.pop();
                answer[descStock.time] = i - descStock.time;
            }
            stack.push(new Stock(prices[i], i));
        }
        while (!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.time] = n - 1 - stock.time;
        }
        return answer;
    }
}

// 배열 인덱스로 해결
class Solution {
    int n;

    public int[] solution(int[] prices) {
        this.n = prices.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++ ) {
            
            for (int j = i + 1; j < n; j++) {
                
                answer[i]++;
                
                if (prices[j] < prices[i]) {
                    break;
                }
            }
        }
        return answer;
    }
}
