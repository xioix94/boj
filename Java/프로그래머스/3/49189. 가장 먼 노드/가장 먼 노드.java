import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {   
        // 인접 연결리스트
        List<LinkedList<Integer>> adjLinkedList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjLinkedList.add(new LinkedList<Integer>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            adjLinkedList.get(edge[i][0]).add(edge[i][1]);
            adjLinkedList.get(edge[i][1]).add(edge[i][0]);
        }
        
        // 발견한 노드 체크
        int[] discovered = new int[n + 1];
        
        // 거리 리스트
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        discovered[1] = 1;
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            for (int neighbor : adjLinkedList.get(curr)) {
                if (discovered[neighbor] == 0) {
                    queue.add(neighbor);
                    discovered[neighbor] = 1;
                    dist[neighbor] = dist[curr] + 1;
                }
            }
        }
        
        // 방문한 노드 중에 제일 큰 수의 방문 수 반환
        int maxValue = -1;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > maxValue) {
                maxValue = dist[i];
            }
        }
        
        // 제일 큰 수에 해당하는 개수 반환
        int result = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == maxValue) {
                result++;
            }
        }
        
        return result;
    }
}