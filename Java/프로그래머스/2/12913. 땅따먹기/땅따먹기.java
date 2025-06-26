class Solution {
    int solution(int[][] land) {
        int row = land.length;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = land[i][j];
                for (int k = 0; k < 4; k++) {
                    if (j == k) {
                        continue;
                    }
                    
                    if (land[i][j] < temp + land[i - 1][k]) {
                        land[i][j] = temp + land[i - 1][k];
                    }
                }
            }
        }
        
        return Math.max(Math.max(Math.max(land[row - 1][0], land[row - 1][1]), land[row - 1][2]), land[row - 1][3]);
    }
}