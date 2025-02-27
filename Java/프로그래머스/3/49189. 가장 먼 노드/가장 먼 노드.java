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
        
        // 가장 멀리 떨어진 노드의 개수
        int[] farthestNodeCount = new int[n + 1];
        Arrays.fill(farthestNodeCount, -1);
        farthestNodeCount[1] = 0;
        
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        discovered[1] = 1;
        while(!queue.isEmpty()) {
            int next = queue.remove();
            for (int i = 1; i < n + 1; i++) {
                if (adjLinkedList.get(next).contains(i) && discovered[i] == 0) {
                    queue.add(i);
                    discovered[i] = 1;
                    farthestNodeCount[i] = farthestNodeCount[next] + 1;
                }
            }
        }
        
        // 방문한 노드 중에 제일 큰 수의 방문 수 반환
        int maxValue = -1;
        for (int i = 1; i < farthestNodeCount.length; i++) {
            if (farthestNodeCount[i] > maxValue) {
                maxValue = farthestNodeCount[i];
            }
        }
        
        // 제일 큰 수에 해당하는 개수 반환
        int result = 0;
        for (int i = 1; i < farthestNodeCount.length; i++) {
            if (farthestNodeCount[i] == maxValue) {
                result++;
            }
        }
        
        return result;
    }
}