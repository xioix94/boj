import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        ArrayList<String> book = new ArrayList<>();
        for (String s : phone_book) {
            book.add(s);
        }
        
        Arrays.sort(phone_book, (a, b) -> { return a.compareTo(b);});
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        return answer;
    }
}