import java.util.*;

class Solution {
    public ArrayList<int[]> solution(int n) {
        return hanoi(n);
    }
    
    public ArrayList<int[]> hanoi(int n) {
        ArrayList<int[]> answer = new ArrayList<>();
        hanoiRecursive(answer, n, 1, 3, 2);
        return answer;
    }
    
    public void hanoiRecursive(ArrayList<int[]> map, int n, int start, int target, int via) {
        if (n == 1) {
            map.add(new int[]{start, target});
            return;
        }
        
        hanoiRecursive(map, n - 1, start, via, target);
        map.add(new int[]{start, target});
        hanoiRecursive(map, n - 1, via, target, start);
    }
}