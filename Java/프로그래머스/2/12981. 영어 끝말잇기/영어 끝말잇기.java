class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int personCount = 1;
        int cycle = 1;
        String previousWord = words[0];
        for (int i = 1; i < words.length; i++) {
            personCount++;
            if (personCount == n + 1) {
                personCount -= n;
                cycle++;
            }
            
            String word = words[i];
            
            // 이전 단어의 마지막 글자와 현재 단어의 첫번째 글자가 다른 경우
            if (previousWord.charAt(previousWord.length() - 1) != word.charAt(0)) {
                answer[0] = personCount;
                answer[1] = cycle;
                return answer;
            }
            
            // 이전에 말했던 단어를 다시 말하는 경우
            for (int j = 0; j < i; j++) {
                if (j == i) {
                    continue;
                }
                
                String checkWord = words[j];
                if (checkWord.equals(word)) {
                    answer[0] = personCount;
                    answer[1] = cycle;
                    return answer;
                }
            }
            
            previousWord = word;

        }
        
        // 단어들 다 통과한 경우 (문제 없는 경우)
        answer[0] = 0;
        answer[1] = 0; 

        return answer;
    }
}