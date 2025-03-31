class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String word : babbling) {
            if (isPronounce(word)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPronounce(String word) {
        int wordIndex = 0;
        String lastWord = "";
        while(true) {
            if (wordIndex > word.length() || wordIndex + 2 > word.length()) {
                return false;
            }
            
            String two = word.substring(wordIndex, wordIndex + 2);
            if (two.equals("ye") && !two.equals(lastWord)) {
                lastWord = "ye";
                wordIndex += 2;
                if (wordIndex == word.length()) {
                    return true;
                }
                
                continue;
            } else if (two.equals("ma") && !two.equals(lastWord)) {
                lastWord = "ma";
                wordIndex += 2;
                if (wordIndex == word.length()) {
                    return true;
                }
                
                continue;
            }
            
            if (wordIndex > word.length() || wordIndex + 3 > word.length()) {
                return false;
            }
            
            String three = word.substring(wordIndex, wordIndex + 3);
            if (three.equals("aya") && !three.equals(lastWord)) {
                lastWord = "aya";
                wordIndex += 3;
                if (wordIndex == word.length()) {
                    return true;
                }
                
                continue;
            } else if (three.equals("woo") && !three.equals(lastWord)) {
                lastWord = "woo";
                wordIndex += 3;
                if (wordIndex == word.length()) {
                    return true;
                }
                
                continue;
            }
            
            return false;
        }
    }
}