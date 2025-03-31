import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int eachPower = getDivisors(i);
            if (eachPower > limit) {
                eachPower = power;
            }
            
            answer += eachPower;
        }
        
        return answer;
    }
    
    public int getDivisors(int number) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                set.add(i);
                set.add(number / i);
            }
        }
        
        return set.size();
    }
}