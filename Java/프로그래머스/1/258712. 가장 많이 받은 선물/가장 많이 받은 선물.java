import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 선물 지수 딕셔너리, 상대 지수 딕셔너리 생성
        Map<String, Integer> score  = new HashMap<>();
        Map<String, Map<String, Integer>> relatedScore = new HashMap<>();
        for (String name : friends) {
            score.put(name, 0);
            Map<String, Integer> temp = new HashMap<>();
            for (String name2 : friends) {
                if (!name.equals(name2)) {
                    temp.put(name2, 0);
                }
            }
            
            relatedScore.put(name, temp);  
        }
        
        for (String names : gifts) {
            String[] splited = names.split(" ");
            
            // 선물 지수 계산
            score.put(splited[0], score.get(splited[0]) + 1);
            score.put(splited[1], score.get(splited[1]) - 1);
            
            // 상대 지수 계산 - 준 사람의 relatedScore 의 점수가 높도록
            relatedScore.get(splited[0]).put(splited[1], relatedScore.get(splited[0]).get(splited[1]) + 1);
        }
        
        
        // friends 돌면서 서로 비교하면서 score에서 점수 비교하고 받은 선물 수 계산
        Map<String, Integer> presentCount = new HashMap<>();
        for (String name : friends) {
            presentCount.put(name, 0);
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String name = friends[i];
                String name2 = friends[j];
                if (name.equals(name2)) {
                    continue;
                }
                
                // 상대 지수 계산
                Integer nameRelatedScore = relatedScore.get(name).get(name2);
                Integer name2RelatedScore = relatedScore.get(name2).get(name);
                if (nameRelatedScore > name2RelatedScore) {
                    presentCount.put(name, presentCount.get(name) + 1);
                } else if (nameRelatedScore < name2RelatedScore) {
                    presentCount.put(name2, presentCount.get(name2) + 1);
                // 상대 지수 같을 시 선물 지수 계산
                } else {
                    Integer nameScore = score.get(name);
                    Integer name2Score = score.get(name2);
                    if (nameScore > name2Score) {
                        presentCount.put(name, presentCount.get(name) + 1);
                    } else if (nameScore < name2Score) {
                        presentCount.put(name2, presentCount.get(name2) + 1);
                    } else {
                        continue;
                    }
                }
            }
        }
        
        Integer maxValue = 0;
        for (String name : friends) {
            if (maxValue < presentCount.get(name)) {
                maxValue = presentCount.get(name);
            }
        }
        
        answer = maxValue;
        return answer;
    }
}