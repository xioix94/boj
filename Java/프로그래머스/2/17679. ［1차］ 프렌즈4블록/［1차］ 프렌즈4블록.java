import java.util.*;

class Index {
    int i;
    int j;
    
    public Index(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
    public int getI() {
        return i;
    }
    
    public int getJ() {
        return j;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return i == index.i && j == index.j;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        while (true) {
            Set<Index> set = new HashSet<>();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (isGood(i, j, board)) {
                        addIndex(i, j, set);
                    }
                }
            }
            
            if (set.size() > 0) {
                answer += set.size();
                arrangeBoard(set, board);
                continue;
            }
            
            break;
        }
        
        return answer;
    }
    
    public boolean isGood(int i, int j, String[] board) {
        if (board[i].charAt(j) != '0' && board[i].charAt(j) == board[i + 1].charAt(j) && board[i + 1].charAt(j) == board[i].charAt(j + 1) && board[i].charAt(j + 1) == board[i + 1].charAt(j + 1)) {
            return true;
        }
        
        return false;
    }
    
    public void addIndex(int i, int j, Set<Index> set) {
        int[][] temp = new int[4][2];
        temp[0] = new int[] {i, j};
        temp[1] = new int[] {i + 1, j};
        temp[2] = new int[] {i, j + 1};
        temp[3] = new int[] {i + 1, j + 1};
        for (int[] t : temp) {
            boolean checker = false;
            Index newIndex = new Index(t[0], t[1]);
            for (Index index : set) {
                if (newIndex.equals(index)) {
                    checker = true;
                    break;
                }                
            }
            
            if (!checker) {
                set.add(newIndex);
            }
        }
    }
    
    public void arrangeBoard(Set<Index> set, String[] board) {
        // 빈 공간은 0으로
        for (Index s : set) {
            int i = s.getI();
            int j = s.getJ();
            
            char[] tempCharArray = board[i].toCharArray();
            tempCharArray[j] = '0';
            board[i] = new String(tempCharArray);
        }
        
        // 0 위에 있는 블럭들을 떨어뜨리기 (아래꺼부터)
        for (int i = board.length - 1; i > -1; i--) {
            for (int j = 0; j < board[0].length(); j++) {
                int below = i;
                for (int k = i + 1; k < board.length; k++) {
                    if (board[k].charAt(j) == '0') {
                        below = k;
                    }
                }
                
                if (below != i) {
                    char[] tempCharArray = board[below].toCharArray();
                    char[] tempCharArray2 = board[i].toCharArray();
                    tempCharArray[j] = board[i].charAt(j);
                    tempCharArray2[j] = '0';
                    board[below] = new String(tempCharArray);
                    board[i] = new String(tempCharArray2);
                }
            }
        }
    }
}