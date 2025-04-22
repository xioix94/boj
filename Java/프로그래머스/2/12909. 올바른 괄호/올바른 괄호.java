class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                count--;
            } else {
                count++;
            }
            
            if (count == -1) {
                return false;
            }
        }
        
        if (count != 0) {
            return false;
        }

        return answer;
    }
}