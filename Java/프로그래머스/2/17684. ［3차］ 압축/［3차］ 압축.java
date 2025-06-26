import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // basic dictionary
        char alphabet = 'A';
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i < 27; i++) {
            map.put(String.valueOf(alphabet), i);
            alphabet++;
        }
        
        int count = 27;
        for (int i = 0; i < msg.length(); i++) {
            String temp = "";
            int j = i;
            while (true) {
                temp += String.valueOf(msg.charAt(j));
                if (map.containsKey(temp)) {
                    j += 1;
                    if (j >= msg.length()) {
                        answer.add(map.get(temp));
                        i += temp.length() - 1;
                        break;
                    }
                } else {
                    map.put(temp, count);
                    count++;
                    answer.add(map.get(temp.substring(0, temp.length() - 1)));
                    i += temp.substring(0, temp.length() - 1).length() - 1;
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}