import java.util.*;

class Solution {
    public int solution(int n) {
        ArrayList<Long> fibo = new ArrayList<>();
        
        fibo.add(0L);
        fibo.add(1L);
        
        for (int i = 2; i <= n; i++) {
            fibo.add((fibo.get(i - 1) + fibo.get(i - 2)) % 1234567);
        }
        
        return fibo.get(n).intValue();
    }
}