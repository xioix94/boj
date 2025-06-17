import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer> array = new ArrayList<>();
        boolean isAllTrue = false;
        int count = 0;
        while(!isAllTrue) {
            
            // 작업량 추가
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            
            // 배포 수 파악
            int temp = 0;
            for (int i = count; i < progresses.length; i++) {
                if (progresses[i] >= 100) {
                    count += 1;
                    temp++;
                } else {
                    break;
                }
            }
            
            if (temp != 0) {
                array.add(temp);
            }
            
            if (count == progresses.length) {
                break;
            }
        }
        
        System.out.println(array);
        answer = array.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}