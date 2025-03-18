import java.util.Arrays;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        boolean isQuadrangle = n % w == 0 ? true : false;
        int[][] matrix = isQuadrangle == true ? new int[n / w][w] : new int[(n / w) + 1][w];
        int totalRow = matrix.length;
        boolean isLeft = true;
        int row = totalRow - 1;
        int col = 0;
        matrix[row][col] = 1;

        // 행렬 채우기
        for (int i = 2; i <= n; i++) {
            if (w == 1) { // w = 1일 때
                row -= 1;
            } else { // w > 1일 때
                if (i % w == 1) { // 새 층 시작
                    row -= 1;
                    col = isLeft ? 0 : w - 1;
                } else {
                    if (isLeft) {
                        col += 1;
                    } else {
                        col -= 1;
                    }
                }
            }

            // 채운다.
            matrix[row][col] = i;

            // 방향을 바꿀 지 판단
            if (i % w == 0) {
                isLeft = isLeft == true ? false : true;
            }
        }

        // 상자 세기
        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == num) {
                    int temp = i;
                    while (matrix[temp][j] != 0) {
                        answer++;
                        temp--;

                        if (temp < 0) {
                            break;
                        }
                    }

                    break;
                }
            }
        }


        return answer;
    }
}