import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {

    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cardNumber = Integer.parseInt(br.readLine());
        for (int card = 1; card <= cardNumber; card++) {
            queue.offer(card);
        }

        boolean isThrowCard = true;
        while (!remainOneCard()) {
            if (isThrowCard) {
                queue.poll();
                isThrowCard = false;
                continue;
            }
            Integer card = queue.poll();
            queue.offer(card);
            isThrowCard = true;
        }

        Integer lastCard = queue.poll();
        System.out.println(lastCard);
    }

    private static boolean remainOneCard() {
        return queue.size() == 1;
    }
}
