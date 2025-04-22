class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] list = s.split(" ");
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 빈 칸인 경우
            if (Character.isWhitespace(c)) {
                answer.append(String.valueOf(c));
                continue;
            }
            
            // 문장의 첫글자인 경우
            if (i == 0) {
                if (isNumber(c)) {
                    answer.append(String.valueOf(c));
                } else {
                    answer.append(String.valueOf(Character.toUpperCase(c)));
                }
                
                continue;
            }
            
            // 단어의 첫 글자인 경우 (앞 문자가 공백)
            if (Character.isWhitespace(s.charAt(i - 1))) {
                answer.append(String.valueOf(Character.toUpperCase(c)));
                continue;
            }
            
            
            // 단어의 첫 글자가 아닌 글자의 경우(앞 문자가 공백이 아님)
            if (!Character.isWhitespace(s.charAt(i - 1))) {
                answer.append(String.valueOf(Character.toLowerCase(c)));
            }
        }
        
        return answer.toString();
    }
    
    public boolean isNumber(char c) {
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
            return true;
        }
        
        return false;
    }
}