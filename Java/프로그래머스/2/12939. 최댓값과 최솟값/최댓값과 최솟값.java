import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strList = s.split(" ");
        ArrayList<Integer> list = new ArrayList();
        for (String str : strList) {
            list.add(Integer.parseInt(str));
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int num : list) {
            if (max < num) {
                max = num;
            }
            
            if (min > num) {
                min = num;
            }
        }
        
        return min + " " + max;
    }
}