import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 명예의 전당
        ArrayList<Integer> order = new ArrayList<>();
        for (int s : score) {
            // order에서 제일 작은 m과 s를 비교
            // m보다 크면 order에서 제거. 같거나 작으면 넘어감
            int min = getMin(order);
            
            // order에 값이 없을 경우 order에 값 넣고 다음 싸이클로.
            if (min == -1) {
                answer.add(s);
                order.add(s);
                System.out.println(order);
                continue;
            }
            
            // order != k 인 경우 추가 후 넘어감
            if (order.size() < k) {
                order.add(s);
                min = getMin(order);
                answer.add(min);
                System.out.println(order);
                continue;
            }
            
            // 제일 작은 값은 answer에 삽입
            if (min < s) {
                // min에 해당하는 인덱스에 s 삽입
                for (int i = 0; i < order.size(); i++) {
                    if (order.get(i) == min) {
                        order.set(i, s);
                        break;
                    }
                 }
                
                System.out.println(order);
                
                // order에서 min 구해서 answer에 삽입
                min = getMin(order);
                
            } 
            
            answer.add(min);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int getMin(ArrayList<Integer> order) {
        if (order.size() == 0) {
            return -1;
        }
        
        int min = 2000;
        for (int o : order) {
            if (min > o) {
                min = o;
            }
        }
        
        return min;
    }
}