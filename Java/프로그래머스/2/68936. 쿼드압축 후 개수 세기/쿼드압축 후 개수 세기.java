class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];     
        int length = arr.length;
        
        answer = numberCount(arr, arr.length);
        
        return answer;
    }
    
    public int[] numberCount(int[][] arr, int length) {
        int[] count = new int[2];
        
        return numberCountRecursive(arr, count, length, 0, 0);
    }
    
    public int[] numberCountRecursive(int[][] arr, int[] count, int length, int row, int col) {
        // 행의 길이가 1인 행렬의 경우 그냥 값 반환
        if (length == 1) {
            if (arr[row][col] == 0) {
                count[0] += 1;
            } else {
                count[1] += 1;
            }
            
            return count;
        }
        
        // 모든 값이 같은 지 확인
        boolean isSame = true;
        int firstNum = arr[row][col];
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (arr[i][j] != firstNum) {
                    isSame = false;
                }
            }
        }
        
        // 모든 값이 같은 경우 반환
        if (isSame) {
            if (firstNum == 0) {
                count[0] += 1;
            } else {
                count[1] += 1;
            }
            
            return count;
        }
        
        // 하나라도 다를 경우 4분할 후 각 영역에 대해서 함수 호출
        plusArray(count, numberCountRecursive(arr, count, length / 2, row, col));
        plusArray(count, numberCountRecursive(arr, count, length / 2, row + (length / 2), col));
        plusArray(count, numberCountRecursive(arr, count, length / 2, row, col + (length / 2)));
        plusArray(count, numberCountRecursive(arr, count, length / 2, row + (length / 2), col + (length / 2)));
        
        return count;
    }
    
    public int[] plusArray(int[] a, int[] b) {
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            result[i] = a[i] + b[i];
        }
        
        return result;
    }
}