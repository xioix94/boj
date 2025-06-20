import java.util.*;

class Node {
    int row;
    int col;
    int count;
    
    public Node(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public int getCount() {
        return count;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int r = maps.length;
        int c = maps[0].length;
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maps[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        
        visited[0][0] = true;
        queue.add(new Node(0, 0, 1));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int rr = node.getRow();
            int cc = node.getCol();
            if (rr == r - 1 && cc == c - 1) {
                return node.getCount();
            }
            
            for (int[] d : directions) {
                if (inRange(rr + d[0], cc + d[1], r, c) && visited[rr + d[0]][cc + d[1]] == false) {
                    visited[rr + d[0]][cc + d[1]] = true;
                    queue.add(new Node(rr + d[0], cc + d[1], node.getCount() + 1));
                }
            }
        }
        
        return -1;
    }
    
    public boolean inRange(int row, int col, int r, int c) {
        if (row < 0 || row > r - 1 || col < 0 || col > c - 1) {
            return false;
        }
        
        return true;
    }
}