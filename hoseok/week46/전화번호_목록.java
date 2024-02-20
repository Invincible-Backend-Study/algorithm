// String을 정렬하면 동일한 prefix를 가지고 있다면 길이가 긴게 뒤로 정렬되기 때문에 오름차순 정렬 후 검증시 유리함
import java.util.*;

class Solution {
    public boolean solution(String[] books) {
        Arrays.sort(books);
        
        for (int i = 0; i < books.length - 1; i++) {
            if (books[i + 1].startsWith(books[i])) {
                return false;
            }
        }
        return true;
    }
}
