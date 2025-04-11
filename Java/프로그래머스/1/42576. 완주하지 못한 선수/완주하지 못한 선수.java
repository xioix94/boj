import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
                continue;
            }
            
            map.put(p, 1);
        }
        
        for (String s : completion) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
                if (map.get(s) == 0) {
                    map.remove(s);
                }
                
                continue;
            }
        }
        
        return String.valueOf(map.keySet().toArray()[0]);
    }
}