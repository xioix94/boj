class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        // t-length() : 7 p.length() : 3 t - p : 4
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            String temp = "";
            for (int j = i; j < i + p.length(); j++) {
                temp += t.charAt(j);
            }
            
            if (Long.parseLong(temp) <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}