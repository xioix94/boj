class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] list = new long[2];
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        list[0] = 1;
        list[1] = 2;
        
        for (int i = 3; i <= n; i++) {
            answer = (list[0] + list[1]) % 1234567;
            list[0] = list[1];
            list[1] = answer;
        }
        
        return answer;
    }
}