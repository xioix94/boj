import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        boolean[] checkSize = new boolean[mats.length];
        for (int i = 0; i < mats.length; i++) {
            if (park.length >= mats[i] && park[0].length >= mats[i]) {
                checkSize[i] = true;
            }
        }
        boolean isAllFalse = false;
        for (int i = 0; i < mats.length; i++) {
            if (checkSize[i] == true) {
                isAllFalse = true;
            }
        }
        
        if (!isAllFalse) {
            return -1;
        }
        
        Arrays.sort(mats);
        int[] matsReverse = new int[mats.length];
        for (int i = mats.length - 1; i > -1; i--) {
            matsReverse[mats.length - i - 1] = mats[i];
        }
        
        mats = matsReverse;
        
        for (int mat : mats) {
            for (int i = 0; i < park.length - mat + 1; i++) {
                for (int j = 0; j < park[0].length - mat + 1; j++) {
                    if (park[i][j].equals("-1")) {
                        if (checkEmpty(i, j, mat, park)) {
                            return mat;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    public boolean checkEmpty(int row, int col, int mat, String[][] park) {
        for (int i = row; i < row + mat; i++) {
            for (int j = col; j < col + mat; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        
        return true;
    }
}