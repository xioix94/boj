import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = Arrays.stream(citations)
                                    .boxed()
                                    .collect(Collectors.toList());
        list.sort(Comparator.reverseOrder());
        
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 <= list.get(i)) {
                answer = i + 1;
            } else {
                break;
            }
        }
        
        return answer;
    }
}