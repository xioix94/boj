class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        long xx = x;
        
        for (int i = 0; i < n; i++) {
            answer[i] = xx + (i  * xx);
        }
        
        return answer;
    }
}