class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        String temp = "";
        boolean isZero = false;
        String[] splited = s.split("0");
        for (String split : splited) {
            if (split.length() != 0) {
                if (isPrime(Long.parseLong(split))) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        if (n == 0 || n == 1) {
            return false;
        }
        
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}