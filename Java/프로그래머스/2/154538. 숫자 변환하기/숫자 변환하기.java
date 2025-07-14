import java.util.*;

class Temp {
    int value;
    int count;
    
    public Temp(int value, int count) {
        this.value = value;
        this.count = count;
    }
    
    public int getValue() {
        return value;
    }
    
    public int getCount() {
        return count;
    }
}
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Temp> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        visited[x] = true;
        queue.offer(new Temp(x, 0));
        
        while (queue.size() > 0) {
            Temp temp = queue.poll();
            if (temp.getValue() == y) {
                return temp.getCount();
            } else {
                if (temp.getValue() + n <= y && visited[temp.getValue() + n] == false) {
                    visited[temp.getValue() + n] = true;
                    queue.offer(new Temp(temp.getValue() + n, temp.getCount() + 1));    
                }
                
                if (temp.getValue() * 2 <= y && visited[temp.getValue() * 2] == false) {
                    visited[temp.getValue() * 2] = true;
                    queue.offer(new Temp(temp.getValue() * 2, temp.getCount() + 1));    
                }
                
                if (temp.getValue() * 3 <= y && visited[temp.getValue() * 3] == false) {
                    visited[temp.getValue() * 3] = true;
                    queue.offer(new Temp(temp.getValue() * 3, temp.getCount() + 1));    
                }
            }
        }
        
        return -1;
    }
}