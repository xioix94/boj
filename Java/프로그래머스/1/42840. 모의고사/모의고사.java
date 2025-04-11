import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        
        int[] first = new int[] {1, 2, 3, 4, 5};
        int firstIndex = 0;
        int[] second = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int secondIndex = 0;
        int[] third = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int thirdIndex = 0;
        
        for (int answer : answers) {
            if (first[firstIndex] == answer) {
                score[0]++;
            }
            
            if (second[secondIndex] == answer) {
                score[1]++;
            }
            
            if (third[thirdIndex] == answer) {
                score[2]++;
            }
            
            firstIndex++;
            secondIndex++;
            thirdIndex++;
            
            if (firstIndex == 5) {
                firstIndex = 0;
            }
            
            if (secondIndex == 8){
                secondIndex = 0;
            }
            
            if (thirdIndex == 10) {
                thirdIndex = 0;
            }
        }
        
        int max = 0;
        for (int s : score) {
            if (max < s) {
                max = s;
            }
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) {
                temp.add(i + 1);
            }
        }
        
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}