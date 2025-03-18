import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        // 인접 행렬 생성
        int[][] adjArray = new int[n + 1][n + 1];
        for (int i = 0; i < fares.length; i++) {
            adjArray[fares[i][0]][fares[i][1]] = fares[i][2];
            adjArray[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        // s에서 출발하는 다익스트라
        int[] startFromS = dijkstra(n, s, adjArray);
        
        // a에서 출발하는 다익스트라
        int[] startFromA = dijkstra(n, a, adjArray);
        
        // b에서 출발하는 다익스트라
        int[] startFromB = dijkstra(n, b, adjArray);
        
        // 비교 후 반환
        answer = startFromS[a] + startFromS[b];
        for (int i = 1; i <= n; i++) {
            if (startFromS[i] != Integer.MAX_VALUE && startFromA[i] != Integer.MAX_VALUE && startFromB[i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, startFromS[i] + startFromA[i] + startFromB[i]);
            }
        }
        
        return answer;
    }
    
    public int[] dijkstra(int n, int start, int[][] adjArray) {
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        
        boolean isVisitedAll = false;
        
        while(!isVisitedAll) {
            int curr = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && result[i] < minDist) {
                    minDist = result[i];
                    curr = i;
                }
            }
            if (curr == -1) break;  // 더 이상 방문할 노드 없음

            // 2. 방문 처리
            visited[curr] = true;

            // 3. 인접 노드 갱신: adjArray[curr][i] != 0으로 인접 확인 (네 의도)
            for (int i = 1; i <= n; i++) {
                if (adjArray[curr][i] > 0 && result[curr] + adjArray[curr][i] < result[i]) {
                    result[i] = result[curr] + adjArray[curr][i];
                }
            }

            // 4. 종료 조건 체크
            isVisitedAll = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    isVisitedAll = false;
                    break;
                }
            }
        }
        
        return result;
    }
}