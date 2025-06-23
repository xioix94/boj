import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashMap<String, Integer> visited = new HashMap<>();
        
        process(dirs, 0, 0, visited);
        
        return visited.size() / 2;
    }
    
    // 방향에 따른 이동
    public void process(String dirs, int r, int c, HashMap<String, Integer> visited) {
        for (int i = 0; i < dirs.length(); i++) {
            Character d = dirs.charAt(i);
            int[] result = move(d, r, c, visited);
            r = result[0];
            c = result[1];
        }
    }
    
    // UDRL에 따른 r, c 갱신
    public int[] move(Character d, int r, int c, HashMap<String, Integer> visited) {
        int[] result = new int[2];
        
        if (d == 'U') {
            if (r > 4) {
                result[0] = r;
            } else {
                result[0] = r + 1;
            }
            
            result[1] = c;
        } else if (d == 'D') {
            if (r < -4) {
                result[0] = r;
            } else {
                result[0] = r - 1;
            }
            
            result[1] = c;
        } else if (d == 'R') {
            if (c > 4) {
                result[1] = c;
            } else {
                result[1] = c + 1;
            }
            
            result[0] = r;
        } else {
            if (c < -4) {
                result[1] = c;
            } else {
                result[1] = c - 1;
            }
            
            result[0] = r;
        }
        
        // 이동한 경우 간선 추가
        if (result[0] != r || result[1] != c) {
            addLine(r, c, result[0], result[1], visited);
        }
        
        return result;
    }
    
    public void addLine(int r, int c, int resultR, int resultC, HashMap<String, Integer> visited) {
        String line = String.valueOf(r) + String.valueOf(c) + String.valueOf(resultR) + String.valueOf(resultC);
        String line2 = String.valueOf(resultR) + String.valueOf(resultC) + String.valueOf(r) + String.valueOf(c);
        if (!visited.containsKey(line)) {
            visited.put(line, 0);
        }
        
        if (!visited.containsKey(line2)) {
            visited.put(line2, 0);
        }
    }
}