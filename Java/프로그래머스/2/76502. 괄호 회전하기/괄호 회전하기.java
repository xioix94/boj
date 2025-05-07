import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            s = moveLeft(s);
            if(isGood(moveLeft(s))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i > -1; i--) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
                continue;
            }
            
            char c = s.charAt(i);
            if (c == '[') {
                char out = stack.pop();
                if (out == ']') {
                    continue;
                } 
                
                stack.push(out);
                stack.push(c);
                continue;
            }
            
            if (c == '{') {
                char out = stack.pop();
                if (out == '}') {
                    continue;
                } 
                
                stack.push(out);
                stack.push(c);
                continue;
            }
            
            if (c == '(') {
                char out = stack.pop();
                if (out == ')') {
                    continue;
                } 
                
                stack.push(out);
                stack.push(c);
                continue;
            }
            
            stack.push(c);
        }
        
        if (stack.size() == 0) {
            return true;
        }
        
        return false;
        
        
    }
    
    public String moveLeft(String s) {
        return s.substring(1) + String.valueOf(s.charAt(0));
    }
}
