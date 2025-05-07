import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> origin = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            origin.put(want[i], number[i]);
        }
        
        int sum = 0;
        for (int num : number) {
            sum += num;
        }
        
        for (int i = 0; i < discount.length - sum + 1; i++) {
            ArrayList<String> subList = new ArrayList<>();
            for (int j = i; j < i + sum; j++) {
                subList.add(discount[j]);
            }
            
            HashMap<String, Integer> compare = new HashMap<>();
            for (String sub : subList) {
                if (compare.containsKey(sub)) {
                    compare.put(sub, compare.get(sub) + 1);
                } else {
                    compare.put(sub, 1);
                }
            }
            
            if (compareTwoList(origin, compare)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean compareTwoList(HashMap<String, Integer> origin, HashMap<String, Integer> compare) {
        for (String key : origin.keySet()) {
            boolean isExits = false;
            for (String key2 : compare.keySet()) {
                if (key.equals(key2)) {
                    isExits = true;
                    if (!origin.get(key).equals(compare.get(key2))) {
                        return false;
                    }
                }
            }
            
            if (!isExits) {
                return false;
            }
        }
        
        return true;
    }
}