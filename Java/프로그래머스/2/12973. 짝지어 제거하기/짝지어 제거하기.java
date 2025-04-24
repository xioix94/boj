import java.util.*;;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        stack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
                continue;
            }
            
            char old = stack.pop();
            char newChar = s.charAt(i);
            if (old == newChar) {
                continue;
            }
            
            stack.push(old);
            stack.push(newChar);
        }
        
        if (stack.size() == 0) {
            return 1;
        }
        
        return 0;
    }
}