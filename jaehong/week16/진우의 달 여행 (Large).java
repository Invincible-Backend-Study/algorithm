import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main{
    public static void main(String...args) throws Exception{
        final var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        final var  N = Integer.parseInt(st.nextToken());
        final var  M = Integer.parseInt(st.nextToken());
        final var space = new int[N+2][M];
        final var cache = new int[N+2][M][3];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Search search = (index, column, direction, func) -> {
            if(index == N+1) {
                return 0;
            }

            if(cache[index][column][direction+1] != 0){
                return cache[index][column][direction+1];
            }

            IntBinaryOperator findMinSearchValue = (acc,next) -> Math.min(acc, func.apply(index + 1, column + next, next, func));
            IntPredicate moveCondition = (i) -> {
                var next = i + column;
                return next != direction && next >= 0 && next < M;

            };
            return cache[index][column][direction+1] = space[index][column] + IntStream.rangeClosed(-1, 1)
                    .filter(moveCondition)
                    .reduce(Integer.MAX_VALUE,findMinSearchValue);
        };
      
        IntStream.range(0, M)
                .map(i -> search.apply(0, i, 0, search))
                .min()
                .ifPresent(System.out::println);
    }

}


@FunctionalInterface
interface Search{
    int apply(int index, int column, int direction,  Search search);
}

