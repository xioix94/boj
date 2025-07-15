import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        ArrayList<String> list = new ArrayList<>();
        for (String f : files) {
            list.add(f);
        }
        
        list.sort((s1, s2) -> {
            
            // 삼등분으로 나누기
            ArrayList<String> split1 = splitThree(s1);
            ArrayList<String> split2 = splitThree(s2);
            
            // HEAD 기준 사전순 (대소문자 구분x)
            if (!split1.get(0).toLowerCase().equals(split2.get(0).toLowerCase())) {
                return split1.get(0).toLowerCase().compareTo(split2.get(0).toLowerCase());
            }
            
            // NUMBER 크기순 (앞에 0무시, 012 = 12)
            if (Integer.parseInt(split1.get(1)) != Integer.parseInt(split2.get(1))) {
                return Integer.parseInt(split1.get(1)) - Integer.parseInt(split2.get(1));
            }
            
            // HEAD, NUMBER 같으면 기존 순서 유지
            return 0;
        });
        
        return list.toArray(new String[list.size()]);
    }
    
    public ArrayList<String> splitThree(String s) {
        int index = 0;
        int index2 = 0;
        ArrayList<String> result = new ArrayList<>();
        
        // HEAD 추출
        for (int i = 0; i < s.length(); i++) {
            if (isNumber(s.charAt(i))) {
                index = i;
                break;
            }
        }
        
        result.add(s.substring(0, index));
        
        // NUMBER 추출
        for (int i = index + 1; i < s.length(); i++) {
            if (!isNumber(s.charAt(i))) {
                index2 = i;
                break;
            }
        }
        
        if (index2 != 0) {
            result.add(s.substring(index, index2));
            result.add(s.substring(index2, s.length()));
        } else {
            result.add(s.substring(index));
        }
        
        return result;
    }
    
    public boolean isNumber(char c) {
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
            return true;
        } 
        
        return false;
    }
}