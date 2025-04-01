import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, Integer> x = new HashMap<>();
        Map<Integer, Integer> y = new HashMap<>();
        for (int i = 0; i < X.length(); i++) {
            int c = Character.getNumericValue(X.charAt(i));
            if (x.containsKey(c)) {
                x.put(c, x.get(c) + 1);
            } else {
                x.put(c, 1);
            }
        }

        for (int i = 0; i < Y.length(); i++) {
            int c = Character.getNumericValue(Y.charAt(i));
            if (y.containsKey(c)) {
                y.put(c, y.get(c) + 1);
            } else {
                y.put(c, 1);
            }
        }
        
        for (int i = 9; i >= 0; i--) {
            if (x.containsKey(i) && y.containsKey(i)) {
                if (answer.length() == 0 && i == 0) {
                    return "0";
                }
                
                int xNum = x.get(i);
                int yNum = y.get(i);
                int min = Math.min(xNum, yNum);
                for (int j = 0; j < min; j++) {
                    answer.append(String.valueOf(i));
                }
            }
        }
        
        if (answer.length() == 0) {
            return "-1";
        }
        
        return answer.toString();
    }
}