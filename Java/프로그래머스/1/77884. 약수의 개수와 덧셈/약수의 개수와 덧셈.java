class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            if (isEven(i)) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
    
    public boolean isEven(int number) {
        int count = 0;
        
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        
        if (count % 2 == 0) {
            return true;
        }
        
        return false;
    }
}