import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 *
 * 자음은 왼쪽
 * 모음은 오른쪽
 *
 * a의 좌표가 (x1,y1)
 * b의 좌표가 (x2,y2)
 *
 * a에 위치하는 데에는 a와 b의 택시 거리
 * x1 - x2 + y1 - y2
 *
 * 키를 누른데 1의 시간
 *
 * 두손을 동시 처리 불가
 *
 *
 * z o a c
 *
 * z(1)
 * o(1)
 * a(2)
 * c(4)
 *
 *
 * 각 좌표를 키 형태로 관리
 *
 * 모음인지 자음인지 확인
 * 모음의 경우 현재 모음 위치 저장
 * 거리 계산
 */
public class Boj20436 {


    public static void main(String...args) throws IOException {
        // 모음
        var vowel = new char[][]{
                {'q','w','e','r','t'},
                {'a','s','d','f','g'},
                {'z','x','c','v'}
        };
        // 자음
        var consonant = new char[][]{
                {'y','u','i','o','p'},
                {'h','j','k','l'},
                {'b','n','m'}
        };

        var counts = new int[][]{
                {5,5},
                {5,4},
                {4,3}
        };

        var leftMaps = new LinkedHashMap<Character, Node>();
        var rightMaps = new LinkedHashMap<Character,Node>();
        for(int i = 0; i < 3; i++){
            var count = counts[i];
            for(int j = 0; j < count[0]; j++){
                leftMaps.put(vowel[i][j], new Node(i, j));
            }

            for(int j = 0; j < count[1]; j++){
                rightMaps.put(consonant[i][j], new Node(i, j + count[0]));
            }
        }

        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = br.readLine().toCharArray();

        var SL = st[0];
        var SR = st[2];

        var previousLeft= SL;
        var previousRight = SR;

        var count = 0;
        for(var c: br.readLine().toCharArray()){
            if(leftMaps.containsKey(c)){
                if(previousLeft == c) count++;
                else {
                    var node = leftMaps.get(c);
                    count += leftMaps.get(previousLeft).calculateDistance(node) + 1;
                    previousLeft = c;
                }
            }
            else if(rightMaps.containsKey(c)){
                if(previousRight == c) count++;
                else {
                    var node = rightMaps.get(c);
                    count += rightMaps.get(previousRight).calculateDistance(node) + 1;
                    previousRight = c;
                }
            }

           // System.out.println(count);

        }

        System.out.println(count);
    }

    static class Node{
    int y; int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int calculateDistance(Node node) {
            return Math.abs(y - node.y) + Math.abs(x - node.x);
        }
    }
}
