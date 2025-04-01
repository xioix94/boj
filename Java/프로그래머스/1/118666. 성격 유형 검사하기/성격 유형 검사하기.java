import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> score = new HashMap<>();
        
        score.put("R", 0);
        score.put("T", 0);
        score.put("C", 0);
        score.put("F", 0);
        score.put("J", 0);
        score.put("M", 0);
        score.put("A", 0);
        score.put("N", 0);
        
        for (int i = 0; i < survey.length; i++) {
            String first = String.valueOf(survey[i].charAt(0));
            String second = String.valueOf(survey[i].charAt(1));
            
            if (choices[i] == 1) {
                score.put(first, score.get(first) + 3);
            } else if (choices[i] == 2) {
                score.put(first, score.get(first) + 2);
            } else if (choices[i] == 3) {
                score.put(first, score.get(first) + 1);
            } else if (choices[i] == 5) {
                score.put(second, score.get(second) + 1);
            } else if (choices[i] == 6) {
                score.put(second, score.get(second) + 2);
            } else if (choices[i] == 7) {
                score.put(second, score.get(second) + 3);
            }
        }
        System.out.println(score);
        
        answer += getHigher("R", "T", score);
        answer += getHigher("C", "F", score);
        answer += getHigher("J", "M", score);
        answer += getHigher("A", "N", score);
        
        return answer;
    }
    
    public String getHigher(String first, String second, Map<String, Integer> score) {
        int firstScore = score.get(first);
        int secondScore = score.get(second);
        if (firstScore == secondScore) {
            int min = 500;
            if (first.charAt(0) < min) {
                min = first.charAt(0);
            }
            
            if (second.charAt(0) < min) {
                min = second.charAt(0);
            }
            
            return (char) min + "";
        }
        
        if (firstScore > secondScore) {
            return first;
        }
        
        return second;
    }
}