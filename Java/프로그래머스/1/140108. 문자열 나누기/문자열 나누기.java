class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 문자열의 길이가 1인 경우 바로 리턴
        if (s.length() == 1) {
            return 1;
        }
        
        // start : 새로운 문자열 뭉치 확인
        boolean start = false;
        int sIndex = 0;
        char criteria = 'a';
        int score = 0;
        while (sIndex < s.length()) {
            // 새로운 문자열 뭉치 시작하는 경우
            // start : true
            // 뭉치 수 추가 : answer++
            // 이번에 뽑은 문자를 기준 문자로
            // 같은 문자인 경우 +, 다른 문자인 경우 - 계산 후 0일 때 뭉치 분리할 score
            if (!start) {
                start = true;
                answer++;
                criteria = s.charAt(sIndex);
                score = 1;
                sIndex++;
                continue;
            }
            
            if (s.charAt(sIndex) == criteria) {
                score++;
            } else {
                score--;
                if (score == 0) {
                    start = false;
                }
            }
            
            sIndex++;
        }
        
        return answer;
    }
}