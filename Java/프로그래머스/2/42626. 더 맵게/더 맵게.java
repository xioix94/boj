import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int s : scoville) {
            heap.offer(s);
        }
        
        while(true) {
            if (heap.size() > 1) {
                if (heap.peek() < K) {
                    int num1 = heap.poll();
                    int num2 = heap.poll();
                    int temp = num1 + (num2 * 2);
                    heap.offer(temp);
                    answer++;
                } else {
                    return answer;
                }
            } else {
                if (heap.peek() < K) {
                    return -1;
                } else {
                    return answer;
                }
            }
        }
    }
}