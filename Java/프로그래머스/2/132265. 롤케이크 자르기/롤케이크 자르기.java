import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        
        int rightCount = right.size();
        
        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            left.add(t);
            right.put(t, right.get(t) - 1);
            if (right.get(t) == 0) {
                right.remove(t);
                rightCount--;
            }
            
            if (left.size() == rightCount) {
                answer++;
            }
        }
        
        return answer;
    }
}