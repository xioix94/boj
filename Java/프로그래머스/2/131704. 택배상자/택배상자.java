import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        int count = 0;
        
        for (int i = order.length; i > 0; i--) {
            stack.push(i);
        }
        
        // order 위주로 
        while (count <= order.length - 1) {
            // 보조
            if (sub.size() != 0) {
                if (order[count] == sub.peek()) {
                    count++;
                    sub.pop();
                    answer++;
                    continue;
                }
            }
            
            // 메인
            if (stack.size() != 0) {
                if (order[count] == stack.peek()) {
                    count++;
                    stack.pop();
                    answer++;
                    continue;
                } else {
                    sub.push(stack.pop());
                    continue;
                }
            } else {
                return answer;
            }
        }
        
        return answer;
    }
}