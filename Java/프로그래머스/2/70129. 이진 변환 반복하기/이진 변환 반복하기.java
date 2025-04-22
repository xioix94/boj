class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCount = 0;
        
        while(true) {
            if (s.equals("1")) {
                break;
            }
                
            int notZero = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    notZero += 1;
                }
            }
                
            s = intoBinaryScale(notZero);
            answer[0] += 1;
        }
        
        answer[1] = zeroCount;
        
        return answer;
    }
    
    public String intoBinaryScale(int len) {
        String result = "";
        
        while (len >= 2) {
            result = String.valueOf(len % 2) + result; 
            len = len / 2;
        }
        
        result = len + result;
        
        return result;
    }
}