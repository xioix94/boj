import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                hs.add(numbers[i] + numbers[j]);
            }
        }
        
        return hs.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}