class Solution {
    public boolean solution(int x) {
        String temp = String.valueOf(x);
        
        int sum = 0;
        for (int i = 0; i < temp.length(); i++) {
            sum += Integer.parseInt(String.valueOf(temp.charAt(i)));
        }
        
        if (x % sum == 0) {
            return true;
        }
        
        return false;
    }
}