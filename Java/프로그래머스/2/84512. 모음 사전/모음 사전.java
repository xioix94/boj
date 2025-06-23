import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        HashMap<String, Integer> array = new HashMap<>();
        answer = dfs(word, "", 0, array);
        
        return answer;
    }
    
    public int dfs(String word, String w, int count, HashMap<String, Integer> array) {
        if (word.equals(w)) {
            return count;
        }
        
        String alphabet = "AEIOU";
        if (w.length() == 5) {
            if (w.charAt(4) == 'U') {
                return count;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (w.charAt(4) == alphabet.charAt(i)) {
                        String temp = w.substring(0, 4) + alphabet.charAt(i + 1);
                        if (!array.containsKey(temp)) {
                            array.put(temp, 0);
                            count = Math.max(dfs(word, temp, count + 1, array), count);
                        }
                        
                        if (array.containsKey(word)) {
                            return count;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < 5; i++) {
                String temp = w + alphabet.charAt(i);
                if (!array.containsKey(temp)) {
                    array.put(temp, 0);
                    count = Math.max(dfs(word, temp, count + 1, array), count);
                }
                
                if (array.containsKey(word)) {
                    return count;
                }
            }
        }
        
        return count;
    }
}