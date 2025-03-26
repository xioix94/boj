class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Index = 0;
        int cards2Index = 0;
        for (int i = 0; i < goal.length; i++) {
            String goalWord = goal[i];
            if (cards1.length > cards1Index && cards1[cards1Index].equals(goalWord)) {
                cards1Index++;
                continue;
            }
            
            if (cards2.length > cards2Index && cards2[cards2Index].equals(goalWord)) {
                cards2Index++;
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}