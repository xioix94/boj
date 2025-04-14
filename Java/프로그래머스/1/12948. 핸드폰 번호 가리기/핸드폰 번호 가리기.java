class Solution {
    public String solution(String phone_number) {
        StringBuilder temp = new StringBuilder();
        int len = phone_number.length();
        
        for (int i = 0; i < len; i++) {
            if (i < len - 4) {
                temp.append("*");
                continue;
            }
            
            temp.append(String.valueOf(phone_number.charAt(i)));
        }
        
        return temp.toString();
    }
}