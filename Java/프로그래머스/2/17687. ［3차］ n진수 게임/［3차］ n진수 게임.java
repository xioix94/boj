class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String pre = "";
        for (int i = 0; i < t * m; i++) {
            pre += changeNumber(n, i);
        }
        
        // 순서에 맞는 것만 추출해서 answer에 추가
        int pCount = 1;
        int tCount = 1;
        for (int i = 0; i < pre.length(); i++) {
            if (pCount == p) {
                answer += String.valueOf(pre.charAt(i));
                
                pCount++;
                tCount++;

                if (tCount == t + 1) {
                    break;
                }

                if (pCount == m + 1) {
                    pCount = 1;
                }
            } else {
                pCount++;
                
                if (pCount == m + 1) {
                    pCount = 1;
                }
            }
            

        }
        
        return answer;
    }
    
    public String changeNumber(int n, int i) {
        String result = "";
        
        while (n <= i) {
            int temp = i % n;
            String tempString = "";
            if (temp > 9) {
                tempString = numberToAlphabet(temp);
            } else {
                tempString = String.valueOf(temp);
            }
            
            result = tempString + result;
            i = i / n;
        }
        
        String tempString = "";
        if (i > 9) {
            tempString = numberToAlphabet(i);
        } else {
            tempString = String.valueOf(i);
        }
        
        result = tempString + result;
        return result;
    }
    
    public String numberToAlphabet(int n) {
        if (n == 10) {
            return "A";
        }
        
        if (n == 11) {
            return "B";
        }
        
        if (n == 12) {
            return "C";
        }
        
        if (n == 13) {
            return "D";
        }
        
        if (n == 14) {
            return "E";
        }
        
        if (n == 15) {
            return "F";
        }
        
        return "";
    }
}