import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> hashmap = new HashMap<>();
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int total = 0;
            boolean isSkip = false;
            for (int j = 0; j < target.length(); j++) {
                // hashmap에 있는 문자
                if (hashmap.containsKey(target.charAt(j))) {
                    System.out.format("character %c minTime %d", target.charAt(j), hashmap.get(target.charAt(j)));
                    System.out.println();
                    if (hashmap.get(target.charAt(j)) == -1) {
                        answer[i] = -1;
                        isSkip = true;
                        break;
                    }
                        
                    total += hashmap.get(target.charAt(j));
                    continue;
                }
                
                // hashmap에 없는 문자
                int minTime = findMinTime(keymap, target.charAt(j));
                System.out.format("character %c minTime %d", target.charAt(j), minTime);
                System.out.println();
                
                // 없는 문자인 경우
                if (minTime == -1) {
                    answer[i] = -1;
                    hashmap.put(target.charAt(j), -1);
                    isSkip = true;
                    break;
                } 
                
                hashmap.put(target.charAt(j), minTime);
                total += minTime;
            }
            
            if (isSkip) {
                continue;
            }
            
            answer[i] = total;
        }
        
        return answer;
    }
                    
    public int findMinTime(String[] keymap, Character alphabet) {
        int minTime = Integer.MAX_VALUE;
        for (String key : keymap) {
            boolean isFind = false;
            for (int i = 0; i < key.length(); i++) {
                if (key.charAt(i) == alphabet) {
                    minTime = Math.min(minTime, i + 1);
                    break;
                }
            }
        }
        
        if (minTime != Integer.MAX_VALUE) {
            return minTime;
        } else {
            return -1;
        }
    }
}