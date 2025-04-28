import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : tangerine) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }    
        }
        
        ArrayList<Integer> temp = new ArrayList<>(map.values());
        Collections.sort(temp, Collections.reverseOrder());

        int sum = 0;
        for (int i : temp) {
            answer++;
            sum += i;
            if (sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}