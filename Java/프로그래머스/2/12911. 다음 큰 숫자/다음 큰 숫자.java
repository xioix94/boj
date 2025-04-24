class Solution {
    public int solution(int n) {
        int nCountOne = countOneFromBinary(n);
        int next = n + 1;
        while(true) {
            int nextCountOne = countOneFromBinary(next);
            if (nCountOne == nextCountOne) {
                break;
            }
            
            next++;
        }
        
        return next;
    }
    
    public int countOneFromBinary(int n) {
        int count = 0;
        
        while (n >= 2) {
            if (n % 2 == 1) {
                count++;
            }
            
            n = n / 2;
        }
        
        if (n == 1) {
            count++;
        }
        
        return count;
    }
}