import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // 사진마다 계산
        
        for (int i = 0; i < photo.length; i++) {
            String[] each = photo[i];
            int sum = 0;
            for (int j = 0; j < name.length; j++) {
                if (Arrays.asList(each).contains(name[j])) {
                    sum += yearning[j];
                }
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}