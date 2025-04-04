import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String temp = three(n);
        System.out.println(temp);
        int result = ten(temp);
        System.out.println(result);
        
        return result;
    }
    
    // 3진법으로 변경
    public String three(int n) {
        String result = "";
        
        while (n > 0) {
            result = String.valueOf(n % 3) + result;
            n /= 3;
        }
        return result;
    }
    
    // 10진법 변경
    public int ten(String n) {
        int result = 0;
        
        for (int i = 0; i < n.length(); i++) {
            result += ((int) Math.pow(3, i) * Integer.parseInt(String.valueOf(n.charAt(i))));
        }

        return result;
    }
}