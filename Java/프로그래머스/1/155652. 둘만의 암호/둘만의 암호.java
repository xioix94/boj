import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        // skip을 hashset으로 변경
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = 0; i < skip.length(); i++) {
            hashset.add((int) skip.charAt(i));
        }
        
        // skip에 있는 문자를 제외한 char 리스트 생성
        ArrayList<Character> skippedArray = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!hashset.contains((int) c)) {
                skippedArray.add(c);
            }
        }
        
        // answer에 값 채우기
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            int currIndex = skippedArray.indexOf(ss);
            int nextIndex = (currIndex + index) % skippedArray.size();
            answer.append(skippedArray.get(nextIndex));
        }
            
        return answer.toString();
    }
}