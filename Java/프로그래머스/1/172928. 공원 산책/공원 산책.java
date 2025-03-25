class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int maxRow = park.length;
        int maxCol = park[0].length();
        int row = -1;
        int col = -1;
        
        // park 행렬로 변경
        // 일반 : 0, 장애물 -1
        int[][] matrix = new int[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (park[i].charAt(j) == 'S') {
                    row = i;
                    col = j;
                    matrix[i][j] = 0;
                } else if (park[i].charAt(j) == 'O') {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        
        // routes 돌기 시작
        for (String route : routes) {
            String[] splited = route.split(" ");
            // splited[0] = 방향, splited[1] = 거리
            // 동, 남의 경우 플러스 방향, 서, 북의 경우 반대
            int isPlusDirection = -1;
            if (splited[0].equals("E") || splited[0].equals("S")) {
                isPlusDirection = 1;
            }
            
            int distance = Integer.parseInt(splited[1]);
            distance *= isPlusDirection;
            
            // distance를 계산 했을 때 행렬의 바깥으로 나가는 지 확인
            if (splited[0].equals("S") || splited[0].equals("N")) {
                if (isInnerMatrix(maxRow, maxCol, row + distance, col) && isObstacleHorizontal(matrix, row, col, row + distance)) {
                    row = row + distance;
                } else { 
                    continue;
                }
            } else {
                if (isInnerMatrix(maxRow, maxCol, row, col + distance) && isObstacleVertical(matrix, row, col, col + distance)) {
                    col = col + distance;
                } else {
                    continue;
                }
            }
            System.out.format("row = %d col = %d", row, col);
            System.out.println();
        }
        
        answer[0] = row;
        answer[1] = col;
        
        return answer;
    }
    
    public boolean isInnerMatrix(int maxRow, int maxCol, int row, int col) {
        if (0 <= row  && row < maxRow && 0 <= col && col < maxCol) {
            return true;
        }
        
        return false;
    }
    
    public boolean isObstacleHorizontal(int[][] matrix, int row, int col, int move) {
        // move가 더 큰 경우
        if (row < move) {
            for (int i = row; i <= move; i++) {
                if (matrix[i][col] == -1) {
                    return false;
                }
            }
            
            return true;
        // row가 더 큰 경우
        } else {
            for (int i = move; i <= row; i++) {
                if (matrix[i][col] == -1) {
                    return false;
                }
            }
            
            return true;
        }

    }
    
    public boolean isObstacleVertical(int[][] matrix, int row, int col, int move) {
        // move가 더 큰 경우
        if (col < move) {
            for (int i = col; i <= move; i++) {
                if (matrix[row][i] == -1) {
                    return false;
                }
            }
            
            return true;
        // col이 더 큰 경우
        } else {
            for (int i = move; i <= col; i++) {
                if (matrix[row][i] == -1) {
                    return false;
                }
            }
            
            return true;
        }
    }
}