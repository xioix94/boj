import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 65536;
        
        // 소문자로 통일
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 두글자씩 잘라서 리스트로 
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        addMap(str1, map1);
        addMap(str2, map2);
        
        System.out.println(map1);
        System.out.println(map2);
        
        // 교집합
        int gyo = getGyo(map1, map2);
        
        // 합집합
        int haap = getHaap(map1, map2);
        
        System.out.format("gyo = %d, haap = %d\n", gyo, haap);
        
        // 지수
        float temp = 0f;
        if (haap == 0 && gyo == 0) {
            return answer;
        } else {
            temp = (float) gyo / haap;
            System.out.println(temp);
            answer *= temp;
        }
        
        return (int) answer;
    }
    
    // 교집합
    public int getGyo(HashMap<String, Integer> m1, HashMap<String, Integer> m2) {
        int count = 0;
        
        for (String key : m1.keySet()) {
            if (m2.containsKey(key)) {
                count += Math.min(m1.get(key), m2.get(key));
            }    
        }
        
        return count;
    }
    
    // 합집합
    public int getHaap(HashMap<String, Integer> m1, HashMap<String, Integer> m2) {
        int count = 0;
        
        for (String key : m1.keySet()) {
            if (m2.containsKey(key)) {
                count += Math.max(m1.get(key), m2.get(key));
            } else {
                count += m1.get(key);
            }
        }
        
        for (String key : m2.keySet()) {
            if (!m1.containsKey(key)) {
                count += m2.get(key);
            }
        }
        
        return count;
    }
    
    public void addMap(String str, HashMap<String, Integer> map) {
        String reg = "^[a-z]+$";
        Pattern pattern = Pattern.compile(reg);
        
        for (int i = 0; i < str.length() - 1; i++) {
            if (i == str.length() - 2) {
                Matcher matcher = pattern.matcher(str.substring(i));
                if (matcher.matches()) {
                    map.put(str.substring(i), map.getOrDefault(str.substring(i), 0) + 1);
                }
            } else {
                Matcher matcher = pattern.matcher(str.substring(i, i + 2));
                if (matcher.matches()) {
                    map.put(str.substring(i, i + 2), map.getOrDefault(str.substring(i, i + 2), 0) + 1);
                }
            }
        }
    }
}