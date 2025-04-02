class Solution {
    public int solution(int[][] sizes) {
        int small = -1;
        int big = -1;
        
        for (int[] size : sizes) {
            // size[0] 큰 거 size[1] 작은거
            int temp = size[0];
            int temp2 = size[1];
            if (size[0] < size[1]) {
                int temp3 = size[0];
                size[0] = size[1];
                size[1] = temp3;
            }
            
            if (small < size[1]) {
                small = size[1];
            }
            
            if (big < size[0]) {
                big = size[0];
            }
        }
        return small * big;
    }
}