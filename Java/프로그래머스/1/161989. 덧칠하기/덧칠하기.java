class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        if (m == 1) {
            return section.length;
        }
        
        if (n == 1) {
            return 1;
        }

        int index = 0;
        while (index < section.length) {
            answer++;
            int paintStart = section[index];
            int paintEnd = paintStart + m - 1;
            
            int nextIndex = index + 1;
            for (int i = nextIndex; i < section.length; i++) {
                if (section[i] <= paintEnd) {
                    nextIndex = i + 1;
                } else {
                    break;
                }
            }
            
            index = nextIndex;
        }
        
        
        return answer;
    }
}