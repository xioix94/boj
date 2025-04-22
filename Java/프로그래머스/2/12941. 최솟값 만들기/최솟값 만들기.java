import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        ArrayList<Integer> bReverse = new ArrayList<>();
        for (int i = B.length - 1; i > -1; i--) {
            bReverse.add(B[i]);
        }
        
        System.out.println(B[0]);
        
        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * bReverse.get(i));    
        }

        return answer;
    }
}